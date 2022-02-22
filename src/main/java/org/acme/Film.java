package org.acme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Film {

@Id int film_id;
String description;
String fulltext;

@Column(name="release_year")
int release_year;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public int getRelease_Year() {
        return release_year;
    }

    public void setRelease_Year(int releaseYear) {
        this.release_year = releaseYear;
    }
}
