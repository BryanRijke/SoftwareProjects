package domain.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Werknemer")
public class Werknemer {
	
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Trigram", length = 3, updatable = false, nullable = false)
	private String trigram;
	
	@Column (name = "Voorletters")
	private String voorletters;
	
	@Column (name = "Tussenvoegsels")
	private String tussenvoegsels;
	
	@Column (name = "Achternaam")
	private String naam;
	
	@Column (name = "Straatnaam")
	private String straatnaam;
	
	@Column (name = "Huisnummer") 
	private int huisnummer;
	
	@Column (name = "Postcode")
	private String postcode;
	
	@Column (name = "Woonplaats")
	private String woonplaats;
	
	@Column (name = "Startdatum")
	@Temporal (TemporalType.DATE)
	private Calendar startDatum;
	
	@Column (name = "Salaris")
	private int salaris;
	
	@Column (name = "Functie")
	private String functie;
	
	@ManyToMany
    @JoinTable (name = "Werk",
    	joinColumns = @JoinColumn (name = "Trigram", foreignKey = @ForeignKey (name = "Werknemer_Trigram_FK")),
    	inverseJoinColumns = @JoinColumn (name = "Projectcode", foreignKey = @ForeignKey (name = "Project_ProjectCode_FK")))
    private Set<Project> projecten = new HashSet<>();
	
	@ManyToOne
	@JoinColumn (name = "Schaalcode", foreignKey = @ForeignKey (name = "Schaal_Schaalcode_FK"))
	private Schaal schaalCode;
	
	@OneToOne (mappedBy = "trigram", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Telefoon telefoonNr;
	
	
	public Werknemer() {
		
	}
	
	public Werknemer(String trigram, String voorletters, String tussenvoegsels, String naam, String straatnaam, 
			int huisnummer, String postcode, String woonplaats, Calendar startDatum, int salaris, String functie) {
		this.trigram = trigram;
		this.voorletters = voorletters;
		this.tussenvoegsels = tussenvoegsels;
		this.naam = naam;
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.woonplaats = woonplaats;
		this.startDatum = startDatum;
		this.salaris = salaris;
		this.functie = functie;
	}

	@Override
	public String toString() {
		return "Werknemer: \nTrigram: " + trigram + "\nVoorletters: " + voorletters + "\nTussenvoegsels: " + tussenvoegsels
				+ "\nNaam: " + naam + "\nStraatnaam: " + straatnaam + "\nHuisnummer: " + huisnummer + "\nPostcode: "
				+ postcode + "\nWoonplaats: " + woonplaats + "\nStart datum: " + startDatum + "\nSalaris: €" + salaris
				+ "\nFunctie: " + functie;
	}

	public String getTrigram() {
		return trigram;
	}

	public void setTrigram(String trigram) {
		this.trigram = trigram;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsels() {
		return tussenvoegsels;
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		this.tussenvoegsels = tussenvoegsels;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public Calendar getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(Calendar startDatum) {
		this.startDatum = startDatum;
	}

	public int getSalaris() {
		return salaris;
	}

	public void setSalaris(int salaris) {
		this.salaris = salaris;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}
}
