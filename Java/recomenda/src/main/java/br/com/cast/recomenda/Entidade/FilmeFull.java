package br.com.cast.recomenda.Entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="full", schema="filme_recomenda")
public class FilmeFull {

		@Id
		private String imdbID;

		private String released;
		private String runtime;
		private String genre;
		private String director;
		private String writer;
		private String actors;
		private String plot;
		private String language;
		private String country;
		private String awards;
		private String production;
		
		
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
		public String getReleased() {
			return released;
		}
		public void setReleased(String released) {
			this.released = released;
		}
		public String getRuntime() {
			return runtime;
		}
		public void setRuntime(String runtime) {
			this.runtime = runtime;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getActors() {
			return actors;
		}
		public void setActors(String actors) {
			this.actors = actors;
		}
		public String getPlot() {
			return plot;
		}
		public void setPlot(String plot) {
			this.plot = plot;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getAwards() {
			return awards;
		}
		public void setAwards(String awards) {
			this.awards = awards;
		}
		public String getProduction() {
			return production;
		}
		public void setProduction(String production) {
			this.production = production;
		}
		

}