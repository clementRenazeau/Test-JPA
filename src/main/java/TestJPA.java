import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestJPA {
	private static final Logger LOG = LoggerFactory.getLogger(TestJPA.class);

	
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzaDB");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		LOG.info("lancement de l'application.");
		
		em.close();
		entityManagerFactory.close();
	}
}
