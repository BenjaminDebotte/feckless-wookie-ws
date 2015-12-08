package fr.ensicaen.si.init;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.DbManagement;

public class ServletContext implements ServletContextListener {

	@Override
	//serveur-apprentissage.ensicaen.fr/
	//172.28.106.1:8080    manager:manager
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("PENIS");
		//DbManagement.getInstance().connexion("jdbc:mysql://localhost/si/");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DbManagement.getInstance().deconnexion();
	}
	
}
