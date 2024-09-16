import { Component, OnInit } from '@angular/core';
import { Producto, ProductosService } from 'src/app/services/productos.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit{

  productos: Producto[] = [];

  ngOnInit(): void {
    this.cargarProductos();
  }

  constructor(private productosService: ProductosService) {}

  cargarProductos() {
    this.productosService.getProductos().subscribe(
      (productos) => {
        this.productos = productos;
      },
      (error) => {
        console.error('Error al obtener los productos', error);
      }
    );
  }

}
