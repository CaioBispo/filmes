create table filme_recomenda.small(
	 title varchar (100) not null,
         year varchar(20),
         imdbID varchar (20) not null primary key,
         tipe varchar(10),
         poster varchar(1000)
);

create table filme_recomenda.full(
	imdbID varchar (20) not null primary key,
        released varchar (200),
        runtime varchar (200),
        Genre varchar (200),
        director varchar (1000),
        writer varchar (1000),
        actors varchar (1000),
        plot varchar (1000),
        language varchar (200),
        country varchar (200),
        awards varchar (1000),
        production varchar (1000)
);

ALTER TABLE filme_recomenda.full
	    ADD CONSTRAINT fk_imdbID
	    FOREIGN KEY (imdbID)
	    REFERENCES filme_recomenda.small(imdbID);