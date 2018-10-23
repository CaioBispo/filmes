package br.com.cast.recomenda.Entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="small", schema="filme_recomenda")
public class FilmeSmall {

		@Id
		private String imdbID;
		
		private String title;
		private String year;
		private String tipe;
		private String poster;
		
		
		public String getImdbID() {
			return imdbID;
		}
		public void setImdbID(String imdbID) {
			this.imdbID = imdbID;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getTipe() {
			return tipe;
		}
		public void setTipe(String tipe) {
			this.tipe = tipe;
		}
		public String getPoster() {
			return poster;
		}
		public void setPoster(String poster) {
			this.poster = poster;
		}


}
