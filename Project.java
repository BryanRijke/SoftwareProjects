package domain.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Project")
public class Project {
	
	@Id
	// @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Projectcode", length = 4, updatable = false, nullable = false)
	private String projectCode;
	
	@Column (name = "Projectnaam")
	private String projectNaam;
	
	@Column (name = "Projectplaat")
	private String projectPlaats;
	
	@Column (name = "Startdatum")
	@Temporal (TemporalType.DATE)
	private Calendar startDatum;
	
	@Column (name = "Bugdget")
	private int budget;
	
	@ManyToMany(mappedBy = "projecten")
    private Set<Werknemer> werknemers = new HashSet<>();
	
	
	public Project() {
		
	}
	
	public Project(String projectCode, String projectNaam, String projectPlaats, Calendar startDatum, int budget) {
		this.projectCode = projectCode;
		this.projectNaam = projectNaam;
		this.projectPlaats = projectPlaats;
		this.startDatum = startDatum;
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Project: \nProjectcode: " + projectCode + "\nProjectnaam: " + projectNaam + "\nProject plaats: "
				+ projectPlaats + "\nStart datum: " + startDatum + "\nBudget: " + budget;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectNaam() {
		return projectNaam;
	}

	public void setProjectNaam(String projectNaam) {
		this.projectNaam = projectNaam;
	}

	public String getProjectPlaats() {
		return projectPlaats;
	}

	public void setProjectPlaats(String projectPlaats) {
		this.projectPlaats = projectPlaats;
	}

	public Calendar getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(Calendar startDatum) {
		this.startDatum = startDatum;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
}
