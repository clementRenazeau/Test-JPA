package console;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Client;
import model.Emprunt;
import model.Livre;

public class BibliothequeApp {
private static final Logger LOG = LoggerFactory.getLogger(BibliothequeApp.class);

	
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		LOG.info("lancement de l'application.");
		
		Livre l=em.find(Livre.class, 1);
		if(l != null){
			LOG.info("livre trouvé");
			LOG.info(l.getTitre());
		}
		
		TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre='Germinal'", Livre.class);
		Livre l2= query.getSingleResult();
		if(l2 != null){
			LOG.info("livre trouvé");
			LOG.info(l.getId().toString());
			LOG.info(l.getTitre());
			LOG.info(l.getAuteur());
		}
		
		Emprunt emprunt = em.find(Emprunt.class, 1);
		if(emprunt != null){
			LOG.info("l'emprunt et ses livres ");
			LOG.info(emprunt.getDateDebut().toString());
			for(Livre li : emprunt.getLivres()){
				LOG.info(li.getTitre());
			}
		}
		Client c1 = em.find(Client.class, 1);
		if(c1 != null){
			LOG.info("le client et ses emprunts ");
			LOG.info(c1.getId().toString());
			for(Emprunt emp : c1.getEmprunts()){
				LOG.info(emp.getDateDebut().toString());
			}
		}
		em.close();
		entityManagerFactory.close();
	}
}
