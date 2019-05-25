package ir.ac.sbu.di.project2.springdatamovielens.service;

import ir.ac.sbu.di.project2.springdatamovielens.model.Rate;
import ir.ac.sbu.di.project2.springdatamovielens.repository.MovieRepository;
import ir.ac.sbu.di.project2.springdatamovielens.repository.RateRepository;
import ir.ac.sbu.di.project2.springdatamovielens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    public void rateMovie(String username, String movie_title, Integer rate) {
        if (rateRepository.findOne(username, movie_title) != null)
            rateRepository.changeRate(username, rate, movie_title, Calendar.getInstance().getTime().getTime());
        else {
            Rate r = new Rate(userRepository.find(username), movieRepository.find(movie_title), rate);
            rateRepository.save(r);
        }
    }

    public Iterable<Rate> getRates(String username) {
        return rateRepository.getTimeSortedRates(username);
    }

}
