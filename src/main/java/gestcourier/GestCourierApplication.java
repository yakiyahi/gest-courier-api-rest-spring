package gestcourier;

import gestcourier.dao.*;
import gestcourier.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class GestCourierApplication implements CommandLineRunner {
	@Autowired
	private ConsernRepository consRepos;
	@Autowired
	private ArriveRepository arriveRepos;
	@Autowired
	private DecisionRepository decisRepos;
	@Autowired
	private DirectRepository directRepos;
	@Autowired
	private CourierRepository courRepo;
	@Autowired
	private UtilisateurRepository userRepos;
	@Autowired
	private ProvenanceRepository provRepos;

	public static void main(String[] args) {
		SpringApplication.run(GestCourierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
