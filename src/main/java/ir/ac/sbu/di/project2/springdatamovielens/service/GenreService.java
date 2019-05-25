package ir.ac.sbu.di.project2.springdatamovielens.service;

import ir.ac.sbu.di.project2.springdatamovielens.model.Genre;
import ir.ac.sbu.di.project2.springdatamovielens.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;


    public Iterable<Genre> getMovieGenres(String movieTitle) {
        return genreRepository.getMovieGenres(movieTitle);
    }
}
