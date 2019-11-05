import java.sql.SQLException;

public class Bestellung {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		ConnectionProv con=new ConnectionProv();
		
		
		
		//con.createKunde("v","anton","peter","n");
		//con.deleteKunde(1);
		//con.updateKunde("Vorname", "domi", 2);
		con.readKunden();
	}

}
