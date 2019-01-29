package domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name = "Telefoon")
public class Telefoon {
	
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Telefoonnummer", length = 10, updatable = false, nullable = false)
	private int telefoonNr;
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "Trigram", foreignKey = @ForeignKey (name = "Werknemer_Trigram"))
	private Werknemer trigram;
	
	
	
	public Telefoon() {
		
	}
	
	public Telefoon(int telefoonNr) {
		this.telefoonNr = telefoonNr;
	}

	@Override
	public String toString() {
		return "Telefoon: \nTelefoonnummer: " + telefoonNr;
	}

	public int getTelefoonNr() {
		return telefoonNr;
	}

	public void setTelefoonNr(int telefoonNr) {
		this.telefoonNr = telefoonNr;
	}
}
