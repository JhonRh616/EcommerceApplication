import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Usuario {
  idUsuario: number;
  nombreUsuario: string;
  apellidoUsuario: number;
  usernameUsuario: string;
  passwordUsuario: string;
}

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private apiUrl = 'http://3.138.186.134:8081/api/ecommerce/usuarios'; 

  constructor(private http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiUrl);
  }
}
