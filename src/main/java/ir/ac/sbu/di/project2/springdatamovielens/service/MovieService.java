package ir.ac.sbu.di.project2.springdatamovielens.service;

import ir.ac.sbu.di.project2.springdatamovielens.model.Genre;
import ir.ac.sbu.di.project2.springdatamovielens.model.Movie;
import ir.ac.sbu.di.project2.springdatamovielens.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Iterable<Movie> findThreeMoviesOfSameGenre(String movieTitle) {
        return movieRepository.findThreeMoviesOfSameGenre(movieTitle);
    }

    public Integer getGenreMoviesCount(Genre genre) {
        return movieRepository.getGenreMoviesCount(genre.getName());
    }

    public Movie getLastLikedMovie(String username) {
        return movieRepository.getLastLikedMovie(username);
    }

    public Iterable<Movie> getLastThreeLikedMovies(String username) {
        return movieRepository.getLastThreeLikedMovies(username);
    }
}
