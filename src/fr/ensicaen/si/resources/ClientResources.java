package fr.ensicaen.si.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.ClientDao;
import model.Client;


public class ClientResources {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private int id;
	
	public ClientResources(UriInfo uriInfo, Request request, int id) { 
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Client getClient() {
		return ClientDao.getInstance().getById(id);
	}
	
}
