package banque;

import java.time.LocalDate;
import java.time.Month;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import console.BibliothequeApp;

public class BanqueApp {
	private static final Logger LOG = LoggerFactory.getLogger(BibliothequeApp.class);
	
	public static void main(String[] args){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Banque pop = new Banque("Banque Populaire");
		Banque caisse = new Banque("Caisse d'Epargne");
		Adresse pat = new Adresse(32, "Rue Jules Ferry", 44300, "Nantes");
		Adresse michmich = new Adresse(8, "Avenue des Peupliers", 49007, "Angers");
		Client michel = new Client("Du_Chêne", "Michel", LocalDate.of(1968, Month.AUGUST, 24), michmich, pop);
		Client patrick = new Client("Meuchaud", "Patrick", LocalDate.of(1975, 3, 15), pat, caisse);
		pop.getClients().add(michel);
		caisse.getClients().add(patrick);
		
		Compte compMich = new Compte("07fg56z", 274.56);
		Client ernestine = new Client("Du_Chêne", "Ernestine", LocalDate.of(1961, Month.JULY, 03), michmich, pop);
		LivretA livretPat = new LivretA("1et0498h", 405, 0.05);
		Compte compPat = new Compte("00645ds96", 1062.00);
		michel.getComptes().add(compMich);
		patrick.getComptes().add(compPat);
		patrick.getComptes().add(livretPat);	
		pop.getClients().add(ernestine);
		ernestine.getComptes().add(compMich);
		Virement virErn = new Virement(LocalDate.of(2018, 04, 03), 200, "Achat vélo", compPat, "Patrick");
		compMich.getOperations().add(virErn);
		
		et.begin();
		
		em.persist(pop);
		em.persist(michel);
		em.persist(compMich);
		em.persist(ernestine);
		em.persist(caisse);
		em.persist(patrick);
		em.persist(compPat);
		em.persist(livretPat);
		em.persist(virErn);
		
		et.commit();
		em.close();
	}
}
