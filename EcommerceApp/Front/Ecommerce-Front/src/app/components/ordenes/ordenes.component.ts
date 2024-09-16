import { Component, OnInit } from '@angular/core';
import { OrdenesService } from 'src/app/services/ordenes.service';
import { Producto, ProductosService } from 'src/app/services/productos.service';
import { Usuario, UsuariosService } from 'src/app/services/usuarios.service';

interface Orden {
  idOrden: number;
  nombreUsuario: string;
  nombreProducto: string;
  valorProducto: number;
  comentariosOrden: string;
}

@Component({
  selector: 'app-ordenes',
  templateUrl: './ordenes.component.html',
  styleUrls: ['./ordenes.component.css']
})
export class OrdenesComponent implements OnInit {

  ordenes: Orden[] = [];
  productos: Producto[] = [];
  usuarios: Usuario[] = [];
  mensaje: string = '';
  idProducto: number = 0;
  idUsuario: number = 0;
  comentariosOrden: string = '';

  // Objeto para la nueva orden
  nuevaOrden: Orden = {
    idOrden: 0,
    nombreUsuario: '',
    nombreProducto: '',
    valorProducto: 0,
    comentariosOrden: ''
  };

  constructor(private ordenesService: OrdenesService, private productosService: ProductosService, private usuariosService: UsuariosService) {}

  ngOnInit(): void {
    this.cargarOrdenes();
    this.cargarProductos();
    this.cargarUsuarios();
  }

  // Método para cargar las órdenes
  cargarOrdenes() {
    this.ordenesService.getOrdenes().subscribe(
      (response) => {
        this.mensaje = response.header.message;
        this.ordenes = response.body;
      },
      (error) => {
        console.error('Error al obtener las órdenes', error);
      }
    );
  }

  cargarUsuarios() {
    this.usuariosService.getUsuarios().subscribe(
      (response) => {
        this.usuarios = response;
        this.idUsuario = this.usuarios[0].idUsuario;
      },
      (error) => {
        console.error('Error al obtener los usuarios', error);
      }
    );
  }

  // Método para cargar los productos
  cargarProductos() {
    this.productosService.getProductos().subscribe(
      (productos) => {
        this.productos = productos;
        this.idProducto = this.productos[0].id;
      },
      (error) => {
        console.error('Error al obtener los productos', error);
      }
    );
  }

  // Método que se ejecuta cuando el usuario selecciona un producto
  seleccionarProducto(event: Event) {
    // Asegúrate de que el target sea un HTMLSelectElement
    const target = event.target as HTMLSelectElement;
    const id = Number(target.value);
  
    const productoSeleccionado = this.productos.find(producto => producto.id === id);
  
    // Verifica que productoSeleccionado no sea null o undefined
    if (productoSeleccionado) {
      this.idProducto = productoSeleccionado.id;
      this.nuevaOrden.valorProducto = productoSeleccionado.precio;
    }
  }

  seleccionarUsuario(event: Event) {
    // Asegúrate de que el target sea un HTMLSelectElement
    const target = event.target as HTMLSelectElement;
    const id = Number(target.value);
  
    const usuarioSeleccionado = this.usuarios.find(usuario => usuario.idUsuario === id);
  
    // Verifica que productoSeleccionado no sea null o undefined
    if (usuarioSeleccionado) {
      this.nuevaOrden.nombreUsuario = usuarioSeleccionado.nombreUsuario;
      this.idUsuario = usuarioSeleccionado.idUsuario;
    }
  }

  // Método para crear una nueva orden
  crearOrden() {
    this.ordenesService.crearOrdenes(this.idUsuario, this.idProducto, this.comentariosOrden);
  }

}
