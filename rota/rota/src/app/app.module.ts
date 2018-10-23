import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { Error404Component } from './pages/error404/error404.component';
import { LoginComponent } from './pages/login/login.component';
import { FilmeComponent } from './pages/filme/filme.component';
import { HttpClientModule } from '@angular/common/http';

//-- USADO PARA UTILIZAÇÂO DE ROTAS
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    LoginComponent,
    FilmeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule //-- UTILIZADO PARA COMUNICAR COM O BACK
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
