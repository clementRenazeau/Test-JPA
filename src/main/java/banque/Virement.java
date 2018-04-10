package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation{
	@Column(name = "BENEFICIAIRE", length = 20, nullable = false)
	private String beneficiaire;

	public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire){
		super(date, montant, motif, compte);
		this.beneficiaire=beneficiaire;
	}
	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	
}
