package ir.ac.sbu.di.project2.springdatamovielens.model;

import org.neo4j.ogm.annotation.*;

import java.util.Calendar;

@RelationshipEntity(type = "RATE")
public class Rate {
    @GraphId
    private Long id;
    @StartNode
    private User user;
    @EndNode
    private Movie movie;
    @Property
    private int rate;

    @Property
    private Long ratedAt;

    public Rate() {
    }

    public Rate(User user, Movie movie, int rate) {
        this.user = user;
        this.movie = movie;
        this.rate = rate;
        this.ratedAt = Calendar.getInstance().getTime().getTime();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setRatedAt(Long ratedAt) {
        this.ratedAt = ratedAt;
    }

    public Long getRatedAt() {
        return ratedAt;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getRate() {
        return rate;
    }
}
