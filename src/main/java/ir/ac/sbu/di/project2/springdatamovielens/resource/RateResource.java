package ir.ac.sbu.di.project2.springdatamovielens.resource;

import ir.ac.sbu.di.project2.springdatamovielens.dto.MovieDto;
import ir.ac.sbu.di.project2.springdatamovielens.dto.RateDto;
import ir.ac.sbu.di.project2.springdatamovielens.model.Movie;
import ir.ac.sbu.di.project2.springdatamovielens.model.Rate;
import ir.ac.sbu.di.project2.springdatamovielens.repository.MovieRepository;
import ir.ac.sbu.di.project2.springdatamovielens.service.MovieService;
import ir.ac.sbu.di.project2.springdatamovielens.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("rest/neo4j/rate")
public class RateResource {

    @Autowired
    RateService rateService;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @PostMapping(consumes = {"application/JSON"})
    public Iterable<MovieDto> rateMovie(@RequestBody RateDto rateDto) {
        rateService.rateMovie(rateDto.getUsername(), rateDto.getMovieTitle(), rateDto.getRate());

        if (rateDto.getRate() > 3) {
            Iterable<Movie> movies = movieService.findThreeMoviesOfSameGenre(rateDto.getMovieTitle());
            ArrayList<MovieDto> movieDtos = new ArrayList<>();
            for (Movie movie : movies)
                movieDtos.add(new MovieDto(movie.getMovieId(), movie.getMovieTitle()));
            return movieDtos;
        }
        return null;

    }

    @GetMapping(value = "/{username}", produces = {"application/JSON"})
    public Iterable<RateDto> getRates(@PathVariable("username") String username) {
        Iterable<Rate> rates = rateService.getRates(username);
        ArrayList<RateDto> rateDtos = new ArrayList<>();
        for (Rate rate : rates)
            rateDtos.add(new RateDto(rate.getUser().getUsername(), rate.getMovie().getMovieTitle(), rate.getRate()));
        return rateDtos;
    }

}

