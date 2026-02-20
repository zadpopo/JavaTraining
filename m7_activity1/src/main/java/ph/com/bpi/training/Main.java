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


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	 // Start server on port 4567 (default)
        port(4569);
        
        get("/check-connection", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("status", "Server is running");
            return JsonUtil.toJson(response);
        });
        // add routes here

        // Get Profile List
        
        // Create Profile List
     

        get("/movies", (req, res) -> {
        	res.type("application/json");
        	List<Movie> movies = movieRepository.findAll();
        	return mapper.writeValueAsString(movies);
        });

        post("/movies", (req, res) -> {
            res.type("application/json");
            Movie m = mapper.readValue(req.body(), Movie.class);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            movieRepository.save(m);
            tx.commit();
            return mapper.writeValueAsString(m);
        });

    }
}