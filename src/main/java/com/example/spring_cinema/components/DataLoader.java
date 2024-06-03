package com.example.spring_cinema.components;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Movie movie = new Movie("Title One", "12A", 120);
        movieService.addMovie(movie);
        Movie movie2 = new Movie ("Title Two", "18", 150);
        movieService.addMovie(movie2);

    }

}
