package tirol_htl_anichstrasse;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
public class Kunde {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String titelv="titel";
	private String vorname;
	private String nachname;
	private String titeln;
	
	
	public Kunde(int id,String titelv,String vorname, String nachname,String titeln) throws SQLException
	{
		
		this.id=id;this.titelv=titelv;this.vorname=vorname;this.nachname=nachname;this.titeln=titeln;
	}
	
	public Kunde()
	{
		
	}
	
	@Override
	public String toString()
	{
		return "Kunde [id=" + id + ", titelv=" + titelv + ", vorname=" + vorname + ", nachname=" + nachname + ", titeln=" +  titeln +  "]";
	}
	
	
	/*public void createAdresse(String stadt,String strasse, String hnr,int plz) throws SQLException
	{
		 
		PreparedStatement prest =con.prepareStatement("insert into adresse(stadt, strasse, hnr, plz) values(?,?,?,?)");
		
		prest.setString(1, stadt);
		prest.setString(2, strasse);
		prest.setString(3, hnr);
		prest.setInt(4, plz);
		
		prest.executeUpdate();
		prest.close();
	}
	*/	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitelv() {
		return titelv;
	}


	public void setTitelv(String titelv) {
		this.titelv = titelv;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public String getTiteln() {
		return titeln;
	}


	public void setTiteln(String titeln) {
		this.titeln = titeln;
	}
	
	
}