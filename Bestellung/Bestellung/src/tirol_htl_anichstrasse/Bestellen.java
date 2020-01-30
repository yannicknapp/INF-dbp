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

public class Bestellen {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private Kunde kunde_id;
	private Adresse adresse_rechnung_id;
	private Adresse adresse_liefer_id;
	private BestellungArtikel bestell_id;
	
	public Bestellen(int id,Kunde k,Adresse ar, Adresse al, BestellungArtikel bi) throws SQLException
	{
		
		this.id=id;this.kunde_id=k;this.adresse_rechnung_id=ar;this.adresse_liefer_id=al;this.bestell_id=bi;
	}
	
	public Bestellen()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Bestellung [id=" + id + ", Kunde=" + kunde_id + ", Rechnungs Adresse=" + adresse_rechnung_id +", Lieferadresse="+adresse_liefer_id+"Artikel="+bestell_id+  "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Kunde getKunde_id() {
		return kunde_id;
	}

	public void setKunde_id(Kunde kunde_id) {
		this.kunde_id = kunde_id;
	}

	public Adresse getAdresse_rechnung_id() {
		return adresse_rechnung_id;
	}

	public void setAdresse_rechnung_id(Adresse adresse_rechnung_id) {
		this.adresse_rechnung_id = adresse_rechnung_id;
	}

	public Adresse getAdresse_liefer_id() {
		return adresse_liefer_id;
	}

	public void setAdresse_liefer_id(Adresse adresse_liefer_id) {
		this.adresse_liefer_id = adresse_liefer_id;
	}

	public BestellungArtikel getBestell_id() {
		return bestell_id;
	}

	public void setBestell_id(BestellungArtikel bestell_id) {
		this.bestell_id = bestell_id;
	}

	

	
	
}
