package dataAccess;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.Flight;



public class FlightDataAccess {
	private EntityManager db;
	private EntityManagerFactory emf;
	private boolean initialize=true;
	String fileName = "Flights.odb";
	
	
	public static void main(String args[]) {
    	new FlightDataAccess();
    }
	
	public FlightDataAccess() {

		if (initialize) {


			File fileToDelete = new File(fileName);
		    if (fileToDelete.exists()) {
		        fileToDelete.delete();
		        new File(fileName + "$").delete();
		        System.out.println("File deleted");
		    }
		}
		open();
		if  (initialize)initializeDB();

		System.out.println("DataAccess created => isDatabaseLocal: ");

		close();


	}


	public void open(){

		emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
		db = emf.createEntityManager();
		System.out.println("DataAccess opened ");

	}

	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	public void initializeDB(){

		db.getTransaction().begin();

		try {

			Flight f1 = new Flight("F1","Donostia","Bilbo");
			f1.addConcreteFlight("CF1-1",newDate(2026,1,23),0,2,3,"12:00");
			f1.addConcreteFlight("CF1-2",newDate(2026,1,23),3,0,3,"12:30");
			f1.addConcreteFlight("CF1-3",newDate(2026,1,23),1,2,2,"13:00");
			f1.addConcreteFlight("CF1-4",newDate(2026,1,23),3,3,0,"14:00");
			f1.addConcreteFlight("CF1-5",newDate(2026,1,23),3,3,0,"15:00");
			f1.addConcreteFlight("CF1-6",newDate(2026,1,23),3,3,0,"16:00");
			f1.addConcreteFlight("CF1-7",newDate(2026,1,23),3,3,0,"17:00");

			Flight f2 = new Flight("F2","Donostia","Madrid");
			f2.addConcreteFlight("CF2-1",newDate(2026,1,23),1,2,3,"12:00");
			f2.addConcreteFlight("CF2-2",newDate(2026,1,23),3,0,3,"12:30");
			f2.addConcreteFlight("CF2-3",newDate(2026,1,23),1,2,2,"13:00");
			f2.addConcreteFlight("CF2-4",newDate(2026,1,23),3,3,0,"14:00");
			f2.addConcreteFlight("CF2-5",newDate(2026,1,23),3,3,0,"15:00");
			f2.addConcreteFlight("CF2-6",newDate(2025,1,23),3,3,0,"16:00");
			f2.addConcreteFlight("CF2-7",newDate(2026,1,23),3,3,0,"17:00");

			Flight f3 = new Flight("F3","Barcelona","Donostia");
			f3.addConcreteFlight("CF3-1",newDate(2026,1,23),1,2,3,"10:00");
			f3.addConcreteFlight("CF3-2",newDate(2026,1,23),3,0,3,"11:00");
			f3.addConcreteFlight("CF3-3",newDate(2026,1,23),1,2,2,"12:00");
			f3.addConcreteFlight("CF3-4",newDate(2026,1,23),3,3,0,"13:00");
			f3.addConcreteFlight("CF3-5",newDate(2026,1,23),3,3,0,"15:00");
			f3.addConcreteFlight("CF3-6",newDate(2026,1,23),3,3,0,"19:00");
			f3.addConcreteFlight("CF3-7",newDate(2026,1,23),3,3,0,"21:00");

			Flight f4 = new Flight("F4","Barcelona","Malaga");
			f4.addConcreteFlight("CF4-1",newDate(2026,1,22),1,2,3,"9:00");
			f4.addConcreteFlight("CF4-2",newDate(2026,1,23),3,0,3,"11:00");
			f4.addConcreteFlight("CF4-3",newDate(2026,1,23),1,2,2,"13:00");
			f4.addConcreteFlight("CF4-4",newDate(2026,1,23),3,3,0,"15:00");
			f4.addConcreteFlight("CF4-5",newDate(2026,1,23),3,3,0,"17:00");
			f4.addConcreteFlight("CF4-6",newDate(2025,1,23),3,3,0,"19:00");
			f4.addConcreteFlight("CF4-7",newDate(2026,1,23),3,3,0,"21:00");

			Flight f5 = new Flight("F5","Malaga","Madrid");
			f5.addConcreteFlight("CF5-1",newDate(2026,1,22),1,2,3,"8:00");
			f5.addConcreteFlight("CF5-2",newDate(2026,1,23),3,0,3,"10:00");
			f5.addConcreteFlight("CF5-3",newDate(2026,1,23),1,2,2,"12:00");
			f5.addConcreteFlight("CF5-4",newDate(2026,1,23),3,3,0,"14:00");
			f5.addConcreteFlight("CF5-5",newDate(2026,1,23),3,3,0,"16:00");
			f5.addConcreteFlight("CF5-6",newDate(2026,1,23),3,3,0,"18:00");
			f5.addConcreteFlight("CF5-7",newDate(2026,1,23),3,3,0,"20:00");


			Flight f6 = new Flight("F6","Malaga","Bilbo");
			f6.addConcreteFlight("CF6-1",newDate(2026,1,22),1,2,3,"8:30");
			f6.addConcreteFlight("CF6-2",newDate(2026,1,23),3,0,3,"10:30");
			f6.addConcreteFlight("CF6-3",newDate(2026,1,23),1,2,2,"12:30");
			f6.addConcreteFlight("CF6-4",newDate(2026,1,23),3,3,0,"14:30");
			f6.addConcreteFlight("CF6-5",newDate(2026,1,23),3,3,0,"16:30");
			f6.addConcreteFlight("CF6-6",newDate(2026,1,23),3,3,0,"18:30");
			f6.addConcreteFlight("CF6-7",newDate(2026,1,23),3,3,0,"20:30");

			Flight f7 = new Flight("F7","Malaga","Granada");
			f7.addConcreteFlight("CF7-1",newDate(2026,1,22),1,2,3,"8:30");

			db.persist(f1);
			db.persist(f2);
			db.persist(f3);
			db.persist(f4);
			db.persist(f5);
			db.persist(f6);
			db.persist(f7);

			db.getTransaction().commit();
			System.out.println("Db initialized");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private Date newDate(int year,int month,int day) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day,0,0,0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

}
