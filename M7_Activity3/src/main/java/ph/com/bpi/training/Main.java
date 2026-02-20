package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import static spark.Spark.*;

import ph.com.bpi.training.controller.MovieController;
import ph.com.bpi.training.service.MovieService; 
import ph.com.bpi.training.util.EntityManagerUtil;
import ph.com.bpi.training.util.JsonUtil;

public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieService movieService = new MovieService(em);
        MovieController movieController = new MovieController(movieService);

    	
    	 // Start server on port 4567 (default)
        port(4501);
        
        get("/check-connection", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("status", "Server is running");
            return JsonUtil.toJson(response);
        });

        movieController.registerRoutes();
    }
}