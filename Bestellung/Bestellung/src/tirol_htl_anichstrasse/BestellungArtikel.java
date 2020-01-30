package tirol_htl_anichstrasse;

import java.sql.SQLException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter (AccessLevel.PUBLIC)
public class BestellungArtikel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long bestell_id;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Artikel artikel_id;
	private long menge;
	
	public BestellungArtikel(int id,Artikel a,int m) throws SQLException
	{
		
		this.bestell_id=id;this.artikel_id=a;this.menge=m;
	}
	
	public BestellungArtikel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Artikel bestellen [Bestellung=" + bestell_id + ", Artikel=" + artikel_id + ", Menge=" + menge +  "]";
	}

	public long getBestell_id() {
		return bestell_id;
	}

	public void setBestell_id(long bestell_id) {
		this.bestell_id = bestell_id;
	}

	public Artikel getArtikel_id() {
		return artikel_id;
	}

	public void setArtikel_id(Artikel artikel_id) {
		this.artikel_id = artikel_id;
	}

	public long getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	

}