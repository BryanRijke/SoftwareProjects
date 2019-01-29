package domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "Schaal")
public class Schaal {
	
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Schaalcode", length = 1, updatable = false, nullable = false)
	private String schaalCode;
	
	@Column (name = "Minimale_salaris")
	private int minSalaris;
	
	@Column (name = "Maximale_salaris")
	private int maxSalaris;
	
	@OneToMany (mappedBy = "schaalCode")
	private List<Werknemer> werknemers = new ArrayList<Werknemer>();
	
	
	public Schaal() {
		
	}
	
	public Schaal(String schaalCode, int minSalaris, int maxSalaris) {
		this.schaalCode = schaalCode;
		this.minSalaris = minSalaris;
		this.maxSalaris = maxSalaris;
	}

	@Override
	public String toString() {
		return "Schaal: \nSchaalcode: " + schaalCode + "\nMinimale salaris: " + minSalaris + "\nMaximale salaris: " + maxSalaris;
	}

	public String getSchaalCode() {
		return schaalCode;
	}

	public void setSchaalCode(String schaalCode) {
		this.schaalCode = schaalCode;
	}

	public int getMinSalaris() {
		return minSalaris;
	}

	public void setMinSalaris(int minSalaris) {
		this.minSalaris = minSalaris;
	}

	public int getMaxSalaris() {
		return maxSalaris;
	}

	public void setMaxSalaris(int maxSalaris) {
		this.maxSalaris = maxSalaris;
	}
}
