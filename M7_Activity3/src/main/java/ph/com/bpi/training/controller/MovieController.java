package ph.com.bpi.training.controller;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ph.com.bpi.training.model.Movie;      
import ph.com.bpi.training.service.MovieService;   
import ph.com.bpi.training.util.JsonUtil;          	

public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void registerRoutes() {

        get("/movies", (req, res) -> {
            res.type("application/json");

            Map<String, Object> response = new HashMap<>();
            response.put("status", "SUCCESS");

            List<Movie> movies = movieService.getAllMovies(); 
            response.put("data", movies);    
            return JsonUtil.toJson(response);
        });

        post("/movies", (req, res) -> {
            res.type("application/json");

            Map<String, Object> response = new HashMap<>();
            response.put("status", "SUCCESS");

            Movie m = JsonUtil.fromJson(req.body(), Movie.class);

            Movie saved = movieService.saveMovie(m); 
            response.put("data", saved);

            return JsonUtil.toJson(response); 
        });
    }
}
