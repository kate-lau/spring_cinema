package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {

        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @DeleteMapping
    public ResponseEntity<Movie> deleteMovieById(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
