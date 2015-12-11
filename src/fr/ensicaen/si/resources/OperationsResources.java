package fr.ensicaen.si.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dao.OperationDao;
import model.Operation;

@Path("/ope")
public class OperationsResources {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
	
	@GET
	@Path("{nom}")
	@Produces(MediaType.TEXT_XML)
	public List<Operation> getOperationsByName(@PathParam("nom") String name) throws SQLException {
		return OperationDao.getInstance().getByName(name).getOperationList();
	}
	
	@GET
	 @Path("{nom}/{prenom}") 
	@Produces(MediaType.TEXT_XML)
	public List<Operation> getOperationsByNameAndFirstname(@PathParam("nom") String name, @PathParam("prenom") String firstname) throws SQLException {
		return OperationDao.getInstance().getByFullName(name, firstname).getOperationList();
	}
	
	@Path("id/{clientid}")
	public List<Operation> getOperationsById(@PathParam("clientid") int id) throws SQLException {
			return OperationDao.getInstance().getById(id);
	}
	
	
}
