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

public class Artikel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	String name;
	double preis;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	
	
	public Artikel(int id,String name,double preis) throws SQLException
	{
		
		this.id=id;this.name=name;this.preis=preis;
	}
	
	public Artikel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Artikel [id=" + id + ", Bezeichnung=" + name + ", preis=" + preis +  "]";
	}

}
