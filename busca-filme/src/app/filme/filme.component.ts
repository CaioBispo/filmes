import { Component, OnInit } from '@angular/core';
import { Filme } from './filme.model';
import { FilmeService } from '../filme.service';

@Component({
  selector: 'app-filme',
  templateUrl: './filme.component.html',
  styleUrls: ['./filme.component.css']
})
export class FilmeComponent implements OnInit {

  filmes: Array<Filme>;
  filme: Filme;

  constructor(private service: FilmeService) { }

  ngOnInit() {
    this.filme = new Filme();
    this.buscarTodos();
  }

  public buscarTodos(): void{
    this.service.getFilmes().subscribe(filmes => this.filmes = filmes);
  }

  private recuperaIndiceDaFilme(id: number): number {
    let indice = this.filmes.findIndex(f => f.id == id);
    return indice;
  }

  public editar(f: Filme): void {
    this.filme = Object.create(f);
  }

  public excluir(id: number): void {
    let indiceARemover = this.recuperaIndiceDaFilme(id);
    this.filmes.splice(indiceARemover, 1);
  }
}