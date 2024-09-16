import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Orden {
  idOrden: number;
  nombreUsuario: string;
  nombreProducto: string;
  valorProducto: number;
  comentariosOrden: string;
}

interface OrdenesResponse {
  header: {
    code: number;
    message: string;
  };
  body: Orden[];
}

@Injectable({
  providedIn: 'root'
})
export class OrdenesService {

  private apiUrlGetOrdenes = 'http://3.15.207.65:8081/api/ecommerce/listar-ordenes'; 
  private apiUrlCreateOrdenes = 'http://localhost:8081/api/ecommerce/crear-orden';

  constructor(private http: HttpClient) {}

  getOrdenes(): Observable<OrdenesResponse> {
    return this.http.get<OrdenesResponse>(this.apiUrlGetOrdenes);
  }

  crearOrdenes(idUsuario: number, idProducto: number, comentarios: string) {
    const body = {
      idUsuario: idUsuario,
      idProducto: idProducto,
      comentarios: comentarios
    };

    this.http.post(this.apiUrlCreateOrdenes, body, {
      headers: { 'Content-Type': 'application/json' }
    })
    .subscribe({
      next: (response) => {
        console.log('Orden creada con éxito', response);
      },
      error: (error) => {
        console.error('Error al crear la orden', error);
      },
      complete: () => {
        console.log('Petición completada');
      }
    });
    
    
  }
}
