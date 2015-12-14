package fr.ensicaen.si.init;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.ClientDao;
import dao.DbClientDao;
import dao.DbOperationDao;
import dao.OperationDao;
import db.DbManagement;

public class ServletContext implements ServletContextListener {

	@Override
	//serveur-apprentissage.ensicaen.fr/
	//172.28.106.1:8080    manager:manager
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			DbManagement.getInstance().setDelegate(new MysqlDbManagement());
			DbManagement.getInstance().connexion("jdbc:mysql://127.0.0.1/si?" +
												"user=2A&password=2A");
			
			ClientDao.getInstance().setDelegate(new DbClientDao());
			OperationDao.getInstance().setDelegate(new DbOperationDao());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DbManagement.getInstance().deconnexion();
	}
	
}
