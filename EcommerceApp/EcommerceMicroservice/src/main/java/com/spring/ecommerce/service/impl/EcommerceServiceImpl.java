package com.spring.ecommerce.service.impl;

import com.spring.ecommerce.dto.OrdenDto;
import com.spring.ecommerce.dto.request.OrderRequestDto;
import com.spring.ecommerce.entity.*;
import com.spring.ecommerce.enums.BusinessErrorEnum;
import com.spring.ecommerce.enums.CatalogoValuesEnum;
import com.spring.ecommerce.exception.CustomApplicationException;
import com.spring.ecommerce.projection.OrdenProjection;
import com.spring.ecommerce.repository.*;
import com.spring.ecommerce.service.EcommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EcommerceServiceImpl implements EcommerceService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private TransaccionesRepository transaccionesRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return new ArrayList<>(usuarioRepository.findAll());
    }

    @Override
    public void createOrder(OrderRequestDto order) {
        try {
            Orden orden = new Orden();
            orden.setIdProducto(order.getIdProducto());
            orden.setIdUsuario(order.getIdUsuario());
            orden.setComentariosOrden(order.getComentarios());

            Orden savedOrder = ordenRepository.save(orden);
            Catalogo catalogo = catalogoRepository.findByNombreCatalogoAndTipoCatalogo(
                    CatalogoValuesEnum.TRANSACTION_CREATED.getNombre(),
                    CatalogoValuesEnum.TRANSACTION_CREATED.getTipo());

            Transacciones transaccion = new Transacciones();
            transaccion.setFechaTransaccion(new Timestamp(System.currentTimeMillis()));
            transaccion.setIdOrden(savedOrder.getIdOrden());
            transaccion.setTipoTransaccion(catalogo.getIdCatalogo());

            Optional<Producto> producto = productoRepository.findById(order.getIdProducto());
            producto.ifPresent(value -> {
                if(value.getCantidadDisponible()==0){
                    throw new CustomApplicationException(BusinessErrorEnum.SIN_STOCK);
                }
                value.setCantidadDisponible(value.getCantidadDisponible() - 1);
                System.out.println(value);
                productoRepository.save(value);
            });

            transaccionesRepository.save(transaccion);
        } catch (Exception e) {
            throw new CustomApplicationException(BusinessErrorEnum.GENERAL_ERROR, e);
        }
    }

    @Override
    public List<OrdenDto> getAllOrders() {
        List<OrdenProjection> projections = ordenRepository.getAllOrdenes();

        return projections.stream().map(projection -> new OrdenDto(
                projection.getIdOrden(),
                projection.getNombreUsuario(),
                projection.getNombreProducto(),
                projection.getValorProducto(),
                projection.getComentariosOrden()
        )).collect(Collectors.toList());
    }
}
