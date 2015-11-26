package fr.ensicaen.si.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/ope")
public class OperationsResources {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
}
