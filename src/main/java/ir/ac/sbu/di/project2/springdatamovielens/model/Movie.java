package ir.ac.sbu.di.project2.springdatamovielens.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Movie {

    @GraphId
    private Long id;
    @Property(name = "movie_id")
    private String movieId;
    @Property(name = "movie_title")
    private String movieTitle;

    public Movie() {
    }

    public Movie(String movieId, String movieTitle) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
    }

    public Long getId() {
        return id;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
