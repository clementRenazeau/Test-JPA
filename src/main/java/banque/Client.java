package banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM", length = 20, nullable = false)
	private String nom;
	@Column(name = "PRENOM", length = 20, nullable = false)
	private String prenom;
	@Column(name = "DATE_NAISSANCE", length = 10, nullable = false)
	private LocalDate dateNaissance;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE", nullable = false)
	private Banque banque;
	@ManyToMany
	@JoinTable(name = "compo", 
		joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"))
	private Set<Compte> comptes;

	public Client() {
		comptes = new HashSet<Compte>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
