package ir.ac.sbu.di.project2.springdatamovielens.resource;

import ir.ac.sbu.di.project2.springdatamovielens.dto.GenreDto;
import ir.ac.sbu.di.project2.springdatamovielens.dto.MovieDto;
import ir.ac.sbu.di.project2.springdatamovielens.model.Genre;
import ir.ac.sbu.di.project2.springdatamovielens.model.Movie;
import ir.ac.sbu.di.project2.springdatamovielens.model.User;
import ir.ac.sbu.di.project2.springdatamovielens.service.GenreService;
import ir.ac.sbu.di.project2.springdatamovielens.service.MovieService;
import ir.ac.sbu.di.project2.springdatamovielens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/neo4j/recommendation")
public class RecommendationResource {

    @Autowired
    MovieService movieService;

    @Autowired
    GenreService genreService;

    @Autowired
    UserService userService;

    @GetMapping(value = "recently-liked/{username}", produces = {"application/JSON"})
    public Iterable<GenreDto> recommendRecentlyLiked(@PathVariable("username") String username) {
        Movie lastLiked = movieService.getLastLikedMovie(username);
        Iterable<Genre> genres = genreService.getMovieGenres(lastLiked.getMovieTitle());
        List<GenreDto> result = new ArrayList<>();
        for (Genre g :
                genres) {
            result.add(new GenreDto(g.getName(), movieService.getGenreMoviesCount(g)));
        }
        return result;

    }

    @GetMapping(value = "people-of-same-taste/{username}", produces = {"application/JSON"})
    public Iterable<MovieDto> recommendPeopleOfSameTaste(@PathVariable("username") String username) {
        User userOfSameTaste = userService.findSimilarUser(username);
        if (userOfSameTaste != null) {
            ArrayList<MovieDto> similarMovies = new ArrayList<>();
            for (Movie movie : movieService.getLastThreeLikedMovies(userOfSameTaste.getUsername()))
                similarMovies.add(new MovieDto(movie.getMovieId(), movie.getMovieTitle()));
            return similarMovies;
        }

        return null;
    }
}
