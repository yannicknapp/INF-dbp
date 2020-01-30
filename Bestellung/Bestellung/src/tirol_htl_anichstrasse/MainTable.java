package tirol_htl_anichstrasse;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTable {
	
	
	

	public static void getTable(String name) {
		// TODO Auto-generated method stub
		
		while(true)
        {
		Scanner scanner = new Scanner(System.in);
        int crud;
        do
        {
            System.out.println();
            System.out.println("1 f�r "+name+" erstellen");
            System.out.println("2 f�r "+name+" loeschen");
            System.out.println("3 f�r "+name+" bearbeiten");
            System.out.println("4 wenn Sie zurueck ins Hauptmen� wollen.");
            System.out.println();
            System.out.println();
            System.out.print("Eingabe: ");
            crud = scanner.nextInt();
            System.out.flush();
        }while(crud < 1 || crud > 4);
        
        if(crud==1)
        {
        	if(name.equals("Kunden"))
        	{
        		createKunde();
        	}
        	if(name.equals("Bestellungen"))
        	{
        		createBestellung();
        	}
        	if(name.equals("Adressen"))
        	{
        		createAdresse();
        	}
        	if(name.equals("Artikel"))
        	{
        		createArtikel();
        	}
        	
        }
        
		
		if(crud==2)
        {
        	if(name.equals("Kunden"))
        	{
        		deleteKunde();
        	}
        	if(name.equals("Bestellungen"))
        	{
        		deleteBestellung();
        	}
        	if(name.equals("Adressen"))
        	{
        		deleteAdresse();
        	}
        	if(name.equals("Artikel"))
        	{
        		deleteArtikel();
        	}
        }
		
		if(crud==3)
        {
        	if(name.equals("Kunden"))
        	{
        		updateKunde();
        	}
        	if(name.equals("Bestellungen"))
        	{
        		updateBestellung();
        	}
        	if(name.equals("Adressen"))
        	{
        		updateAdresse();
        	}
        	if(name.equals("Artikel"))
        	{
        		updateArtikel();
        	}
        }
		if(crud==4)
        {
        	return;
        }
        	
        }
		
	}

	private static void updateArtikel() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		long id;
		String name;
		int preis;
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	List<Artikel> bestellungen=m.createQuery("select a from Artikel a").getResultList();
    	for(Artikel b : bestellungen) 
    	{
    		System.out.println(b);
    	}
		System.out.println();
        System.out.println("ID des Artikels: "); id=scanner.nextLong();
        System.out.println("Artikelname: "); name=scanner.next();
        System.out.println("Preis: "); preis=scanner.nextInt();
        System.out.flush();
        
        Artikel artikel=m.find(Artikel.class, id);
		artikel.setName(name);
		artikel.setPreis(preis);
		
    	m.getTransaction().begin();
    	m.persist(artikel);
  		m.getTransaction().commit();
		
	}

	private static void updateBestellung() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	
    	List<Bestellen> bestellungen=m.createQuery("select a from Bestellen a").getResultList();
    	for(Bestellen b : bestellungen) 
    	{
    		System.out.println(b);
    	}
		System.out.println();
		System.out.println("ID von Artikelbestellung: "); long artikelbest = scanner.nextLong();
        System.out.println("ID von neuem Artikel: "); long name = scanner.nextLong();
        System.out.println("Menge: "); int preis = scanner.nextInt();
        System.out.flush();
		
        
        Artikel a=m.find(Artikel.class, name);
		BestellungArtikel b=m.find(BestellungArtikel.class,artikelbest);
		b.setArtikel_id(a);
		b.setMenge(preis);
		
    	m.getTransaction().begin();
    	m.persist(b);
  		m.getTransaction().commit();
  		
		
	}

	private static void updateAdresse() {
		// TODO Auto-generated method stub
		String stadt;
		String strasse;
		String hnr;
		int plz;
		long id;
		Scanner scanner = new Scanner(System.in);
        
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	
		List<Adresse> bestellungen=m.createQuery("select a from Adresse a").getResultList();
    	for(Adresse b : bestellungen) 
    	{
    		System.out.println(b);
    	}
        
        System.out.println();
        System.out.println("Adresse ID: "); id=scanner.nextLong();
        System.out.println("strasse: "); strasse=scanner.next();
        System.out.println("stadt: "); stadt=scanner.next();
        System.out.println("hnr: "); hnr=scanner.next();
        System.out.println("plz: "); plz=scanner.nextInt();
        System.out.flush();
        
        
		Adresse k=m.find(Adresse.class,id);
		k.setHnr(hnr);
		k.setPlz(plz);
		k.setStadt(stadt);
		k.setStrasse(strasse);
		System.out.println(k);
		m.getTransaction().begin();
    	m.persist(k);
  		m.getTransaction().commit();
		
	}

	private static void deleteArtikel() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long id;
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	
    	List<Artikel> artikel=m.createQuery("select a from Artikel a").getResultList();
    	for(Artikel b : artikel) 
    	{
    		System.out.println(b);
    	}
		System.out.println();
        System.out.println("ID des Artikels der gel�scht werden soll: "); id=scanner.nextLong();
        
        System.out.flush();
        List<Bestellen> bestellen=m.createQuery("select a from Bestellen a").getResultList();
    	for(Bestellen b : bestellen) 
    	{
    		m.getTransaction().begin();
    		m.remove(b);
    		m.getTransaction().commit();
    	}
        List<BestellungArtikel> bestellungen=m.createQuery("select a from BestellungArtikel a").getResultList();
    	for(BestellungArtikel b : bestellungen) 
    	{
    		m.getTransaction().begin();
    		m.remove(b);
    		m.getTransaction().commit();
    	}
		
		Artikel a=m.find(Artikel.class,id);
		m.getTransaction().begin();
		m.remove(a);
		m.getTransaction().commit();
		
	}

	private static void deleteBestellung() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		long id;
		
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	
    	List<Bestellen> bestellen=m.createQuery("select a from Bestellen a").getResultList();
    	for(Bestellen b : bestellen) 
    	{
    		System.out.println(b);
    	}
		System.out.println();
        System.out.println("ID der Bestellung die gel�scht werden soll: "); id=scanner.nextLong();
        
        System.out.flush();
		
		
		Bestellen b=m.find(Bestellen.class,id);
		m.getTransaction().begin();
		m.remove(b);
		m.getTransaction().commit();
		
	}

	private static void createBestellung() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        
		
        
        System.out.println();
        System.out.println("Artikel ID: "); long name = scanner.nextLong();
        System.out.println("Menge: "); int preis = scanner.nextInt();
        System.out.flush();
		
        EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
        Artikel a=m.find(Artikel.class, name);
		BestellungArtikel b=new BestellungArtikel();
		b.setArtikel_id(a);
		b.setMenge(preis);
		
    	m.getTransaction().begin();
    	m.persist(b);
  		m.getTransaction().commit();
  		
  		System.out.println();
  		System.out.println("Kunden ID: "); long kid = scanner.nextLong();
        System.out.println("Lieferadresse ID: "); long la = scanner.nextLong();
        System.out.println("Rechnungsadresse ID: "); long ra = scanner.nextLong();
        System.out.flush();
        
        
        Adresse lieferadresse=m.find(Adresse.class, la);
        Adresse rechungsadresse=m.find(Adresse.class, ra);
        Kunde k=m.find(Kunde.class, kid);
        Bestellen bestellen=new Bestellen();
        bestellen.setAdresse_liefer_id(lieferadresse);
        bestellen.setAdresse_rechnung_id(rechungsadresse);
        bestellen.setBestell_id(b);
        bestellen.setKunde_id(k);
        
        m.getTransaction().begin();
    	m.persist(bestellen);
  		m.getTransaction().commit();
		
	}

	private static void createArtikel() {
		// TODO Auto-generated method stub
		String name;
		double preis;
		
		Scanner scanner = new Scanner(System.in);
        
        
        System.out.println();
        System.out.println("Artikelname: "); name=scanner.next();
        System.out.println("Preis: "); preis=scanner.nextInt();
        System.out.flush();
        
        Artikel artikel=new Artikel();
		artikel.setName(name);
		artikel.setPreis(preis);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	m.getTransaction().begin();
    	m.persist(artikel);
  		m.getTransaction().commit();
		
	}

	private static void deleteAdresse() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long id;
		
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	List<Adresse> ad=m.createQuery("select a from Adresse a").getResultList();
    	for(Adresse b : ad) 
    	{
    		System.out.println(ad);
    	}
		System.out.println();
        System.out.println("ID der Adresse die gel�scht werden soll: "); id=scanner.nextLong();
        
        System.out.flush();
		
		
		Adresse k=m.find(Adresse.class,id);
		m.getTransaction().begin();
		m.remove(k);
		m.getTransaction().commit();
		
	}

	private static void createAdresse() {
		// TODO Auto-generated method stub
		
		String stadt;
		String strasse;
		String hnr;
		long plz;
		Scanner scanner = new Scanner(System.in);
        
        
        System.out.println();
        System.out.println("Stadt: "); stadt=scanner.next();
        System.out.println("Strasse: "); strasse=scanner.next();
        System.out.println("Postleitzahl: "); hnr=scanner.next();
        System.out.println("Hausnummer: "); plz=scanner.nextLong();
        System.out.flush();
        
        Adresse adresse=new Adresse();
		adresse.setHnr(hnr);
		adresse.setPlz(plz);
		adresse.setStadt(stadt);
		adresse.setStrasse(strasse);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	m.getTransaction().begin();
    	m.persist(adresse);
  		m.getTransaction().commit();
		
	}

	private static void updateKunde() {
		// TODO Auto-generated method stub
		String vorname;
		String nachname;
		String titelv;
		String titeln;
		long id;
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
		List<Kunde> ku=m.createQuery("select a from Kunde a").getResultList();
    	for(Kunde b : ku) 
    	{
    		System.out.println(ku);
    	}
        
        System.out.println();
        System.out.println("ID des Kunden: "); id=scanner.nextLong();
        System.out.println("Vorname: "); vorname=scanner.next();
        System.out.println("Nachname: "); nachname=scanner.next();
        System.out.println("Titelv: "); titelv=scanner.next();
        System.out.println("Titeln: "); titeln=scanner.next();
        System.out.flush();
        
        
		Kunde k=m.find(Kunde.class,id);
		k.setVorname(vorname);
		k.setNachname(nachname);
		k.setTiteln(titeln);
		k.setTitelv(titelv);
		System.out.println(k);
		m.getTransaction().begin();
    	m.persist(k);
  		m.getTransaction().commit();
		
	}

	private static void deleteKunde() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		long id;
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	List<Kunde> ku=m.createQuery("select a from Kunde a").getResultList();
    	for(Kunde b : ku) 
    	{
    		System.out.println(ku);
    	}
		System.out.println();
        System.out.println("ID des Kunden der gel�scht werden soll: "); id=scanner.nextLong();
        
        System.out.flush();
        List<Bestellen> bestellen=m.createQuery("select a from Bestellen a").getResultList();
    	for(Bestellen b : bestellen) 
    	{
    		m.getTransaction().begin();
    		m.remove(b);
    		m.getTransaction().commit();
    	}
		
		Kunde k=m.find(Kunde.class,id);
		m.getTransaction().begin();
		m.remove(k);
		m.getTransaction().commit();

		
	}

	private static void createKunde() {
		// TODO Auto-generated method stub
		String vorname;
		String nachname;
		String titelv;
		String titeln;
		Scanner scanner = new Scanner(System.in);
        
        
        System.out.println();
        System.out.println("Vorname: "); vorname=scanner.next();
        System.out.println("Nachname: "); nachname=scanner.next();
        System.out.println("Titelv: "); titelv=scanner.next();
        System.out.println("Titeln: "); titeln=scanner.next();
        System.out.flush();
        
        Kunde customer=new Kunde();
		customer.setNachname(nachname);
		customer.setVorname(vorname);
		customer.setTiteln(titeln);
		customer.setTitelv(titelv);
		EntityManagerFactory f= Persistence.createEntityManagerFactory("MyUnit");
    	EntityManager m= f.createEntityManager();
    	m.getTransaction().begin();
    	m.persist(customer);
  		m.getTransaction().commit();
        
		
	}

	

}