import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionProv {

	
	  Connection con;
	
	
	
	
	public ConnectionProv() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bestell","postgres", "Yannic99");
		
	}
	
	
	
	
	
	public void createKunde(String titelv,String vorname, String nachname,String titeln) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("insert into kunde(titelv, vorname, nachname, titeln) values(?,?,?,?)");
		
		prest.setString(1, titelv);
		prest.setString(2, vorname);
		prest.setString(3, nachname);
		prest.setString(4, titeln);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void createAdresse(String stadt,String strasse, String hnr,int plz) throws SQLException
	{
		 
		PreparedStatement prest =con.prepareStatement("insert into adresse(stadt, strasse, hnr, plz) values(?,?,?,?)");
		
		prest.setString(1, stadt);
		prest.setString(2, strasse);
		prest.setString(3, hnr);
		prest.setInt(4, plz);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void createKunde(String name,double preis) throws SQLException
	{
		PreparedStatement prest =con.prepareStatement("insert into kunde(name, preis) values(?,?)");
		
		prest.setString(1, name);
		prest.setDouble(2, preis);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void deleteKunde(int id) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("delete from kunde where id=?");
		
		prest.setInt(1, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void deleteAdresse(int id) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("delete from adresse where id=?");
		
		prest.setInt(1, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void deleteArtikel(int id) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("delete from artikel where id=?");
		
		prest.setInt(1, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void updateKunde(String change, String wert, int id) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("update kunde set "+change+" =? where id=?");
		
		prest.setString(1, wert);
		prest.setInt(2, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void updateAdresse(String change, String wert, int id) throws SQLException
	{
		
		PreparedStatement prest =con.prepareStatement("update adresse set"+change+"=? where id=?");
		
		prest.setString(1, wert);
		prest.setInt(2, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void updateArtikel(String change, String wert, int id) throws SQLException
	{
		PreparedStatement prest =con.prepareStatement("update artikel set"+change+"=? where id=?");
		
		prest.setString(1, wert);
		prest.setInt(2, id);
		
		prest.executeUpdate();
		prest.close();
	}
	
	
	public void readKunden() throws SQLException
	{
		PreparedStatement prest =con.prepareStatement("select * from kunde");
		ResultSet rs = prest.executeQuery();
		System.out.println("id | titelv | vorname | nachname | titeln");
		
		while (rs.next())
		{
			int id= rs.getInt("id");
			String titelv=rs.getString("titelv");
			String vorname=rs.getString("vorname");
			String nachname=rs.getString("nachname");
			String titeln=rs.getString("titeln");
			
			System.out.println(id+" | "+titelv+" | "+vorname+" | "+nachname+" | "+titeln);
		}
		
		
		
	}
	
	
}
