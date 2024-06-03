package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, long id){
        Movie movieToBeUpdated = movieRepository.findById(id).get();
        movieToBeUpdated.setTitle(movie.getTitle());
        movieToBeUpdated.setRating(movie.getRating());
        movieToBeUpdated.setDuration(movie.getDuration());
        return movieToBeUpdated;
    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }

}
