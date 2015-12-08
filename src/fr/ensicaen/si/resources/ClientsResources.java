package fr.ensicaen.si.resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.ClientDao;
import model.Client;

@Path("/clients")
public class ClientsResources {
		
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("")
	public List<Client> getClients() {
		/* Interroger la DB */
		return ClientDao.getInstance().getClients();
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		String countStr = "";
		//countStr = "10";
		try {
			countStr = new Integer(ClientDao.getInstance().countClient()).toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countStr;
		
	}
	
	@GET
	@Path("{client}")
	@Produces(MediaType.TEXT_XML)
	public List<Client> getClientByName(@PathParam("client") String name) {
		return ClientDao.getInstance().getByName(name);
	}
	
	@Path("id/{clientid}")
	public ClientResources getClientById(@PathParam("clientid") int id) {
		//return new ClientResources(uriInfi, request, id);
		return new ClientResources(id);
	}
	
}
