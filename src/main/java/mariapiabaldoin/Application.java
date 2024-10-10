package mariapiabaldoin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mariapiabaldoin.dao.EventiDAO;
import mariapiabaldoin.dao.LocationsDAO;
import mariapiabaldoin.dao.PartecipazioniDAO;
import mariapiabaldoin.dao.PersoneDAO;
import mariapiabaldoin.entities.*;


import java.time.LocalDate;


public class Application {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("giorno-3-15");


	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		PersoneDAO personeDAO = new PersoneDAO(em);
		LocationsDAO locationsDAO = new LocationsDAO(em);
		EventiDAO eventiDAO = new EventiDAO(em);
		PartecipazioniDAO partecipazioniDAO = new PartecipazioniDAO(em);


		Persona persona = new Persona("Mario", "Bros", "supermarioo@gmail.com", LocalDate.of(2000, 10, 29), Sesso.M);
		personeDAO.save(persona);


		Location location = new Location("Piazza Maggiore", "Bologna");
		locationsDAO.save(location);


		Evento evento = new Evento("Mercatini", LocalDate.of(2024, 12, 23), "Natale", TipoEvento.PUBBLICO, 50);
		evento.setLocation(location);
		eventiDAO.save(evento);
	

		Partecipazione partecipazione = new Partecipazione(persona, evento,StatoPartecipazione.CONFERMATA);
		partecipazioniDAO.save(partecipazione);





		em.close();
		emf.close();

	}
}
