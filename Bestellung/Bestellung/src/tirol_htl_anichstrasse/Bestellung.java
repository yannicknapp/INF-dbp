package tirol_htl_anichstrasse;
import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Bestellung {

	private static Scanner scanner;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		
		while(true)
		{
			scanner = new Scanner(System.in);
	        int table;
		do
		{
		
       
        System.out.println("Was wollen sie tun?");
        System.out.println("W�len Sie die 1 um etwas beim Kunden zu �ndern");
        System.out.println("W�len Sie die 2 um die Bestellungen zu �ndern");
        System.out.println("W�len Sie die 3 um die Adressen zu �ndern");
        System.out.println("W�len Sie die 4 um die Artikel zu �ndern");
        System.out.print("Eingabe: ");
        table = scanner.nextInt();
        System.out.flush();
        
		}while(table<1||table>4);
        
        	
        	switch(table)
        	{
        		
		        case 1: MainTable.getTable("Kunden"); break;
		        case 2: MainTable.getTable("Bestellungen"); break;
		        case 3: MainTable.getTable("Adressen"); break;
		        case 4: MainTable.getTable("Artikel"); break;
        	}
		
    
		}
        

		/*Kunde customer=new Kunde();
		customer.setNachname("Pius");
		customer.setVorname("Fabayern");
		customer.setTiteln("n");
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	m.getTransaction().begin();
    	m.persist(customer);
  		m.getTransaction().commit();
    	*/
		/*EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
		Kunde k=m.find(Kunde.class,2L);
		System.out.println(k);
		k.setNachname("Maxi");
		m.getTransaction().begin();
		m.remove(k);
		m.getTransaction().commit();
		System.out.println(k);
		
		m.getTransaction().begin();
		m.remove(k);
		m.getTransaction().commit();
		
		
		
		
		BestellenArtikel b=new BestellenArtikel();
		b.setArtikel_id(1);
		b.setMenge(2);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	m.getTransaction().begin();
    	m.persist(b);
  		m.getTransaction().commit();
		
		
		*/
		//con.createKunde("v","anton","peter","n");
		//con.deleteKunde(1);
		//con.updateKunde("Vorname", "domi", 2);
			
	}

}