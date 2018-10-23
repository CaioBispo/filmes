import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { Filme } from './filme/filme.model';

const URL_API: string = 'http://localhost:8080/recomenda';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {


 

  constructor(private http: HttpClient) { }

  getFilmes(): Observable<Filme[]>{

    return this.http.get<Filme[]>(URL_API);
  }
}
