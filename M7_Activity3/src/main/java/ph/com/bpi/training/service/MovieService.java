package ph.com.bpi.training.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import ph.com.bpi.training.model.Movie; 
import ph.com.bpi.training.repository.MovieRepository;

public class MovieService {

    private EntityManager em; 
    private MovieRepository movieRepository;

    public MovieService(EntityManager em) {
        this.em = em;
        this.movieRepository = new MovieRepository(em);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie m) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        movieRepository.save(m); 
        tx.commit();
        return m;
    }
}