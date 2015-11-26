package fr.ensicaen.si.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.Client;


public class ClientResources {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Client> getClients() {
		/* Interroger la DB */
		ArrayList<Client> list = new ArrayList<>();
		list.add(new Client(1,"Bedouin","Connard"));
		return list;
	}
}
