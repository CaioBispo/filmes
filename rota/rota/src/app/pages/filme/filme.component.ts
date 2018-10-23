import { Component, OnInit } from '@angular/core';
import { Filme } from './filme.model';
import { FilmeService } from 'src/app/filme.service';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-filme',
  templateUrl: './filme.component.html',
  styleUrls: ['./filme.component.css']
})
export class FilmeComponent implements OnInit {

  filmes: Array<Filme>;
  filme: Filme;

  constructor(private service: FilmeService, private router: Router) { }

  ngOnInit() {
    this.filme = new Filme();
    this.buscarTodos();
  }

  public buscarTodos(): void{
    this.service.getFilmes().subscribe(req => this.filmes = req);
  }

}