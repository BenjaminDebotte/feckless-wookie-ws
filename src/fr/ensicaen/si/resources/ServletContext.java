package fr.ensicaen.si.resources;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.DbManagement;

public class ServletContext implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DbManagement.getInstance().deconnexion();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/* Insérer ici toutes les initialisations */
		try {
			DbManagement.getInstance().connexion("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
