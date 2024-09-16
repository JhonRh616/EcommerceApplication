import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Producto {
  id: number;
  nombre: string;
  precio: number;
  proveedor: string;
  tipoProducto: string;
  cantidad: number
}

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  private apiUrl = 'https://jk7kkadyve.execute-api.us-east-2.amazonaws.com/Produccion/ecommerce-producto'; 

  constructor(private http: HttpClient) { }

  getProductos(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.apiUrl);
  }
}
