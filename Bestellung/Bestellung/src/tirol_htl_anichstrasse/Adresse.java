package tirol_htl_anichstrasse;

import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter (AccessLevel.PUBLIC)
public class Adresse {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHnr() {
		return hnr;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}

	public long getPlz() {
		return plz;
	}

	public void setPlz(long plz) {
		this.plz = plz;
	}

	private String stadt;
	private String strasse;
	private String hnr;
	private long plz;
	
	
	public Adresse(int id,String stadt,String strasse, String hnr,long plz) throws SQLException
	{
		
		this.id=id;this.stadt=stadt;this.strasse=strasse;this.hnr=hnr;this.plz=plz;
	}
	
	public Adresse()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Adress [id=" + id + ", stadt=" + stadt + ", strasse=" + strasse + ", hnr=" + hnr + ", plz=" +  plz +  "]";
	}

}
