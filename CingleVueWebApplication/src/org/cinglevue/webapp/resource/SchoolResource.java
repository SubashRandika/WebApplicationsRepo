package org.cinglevue.webapp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.cinglevue.webapp.dao.ShcoolDAO;
import org.cinglevue.webapp.util.Util;

@Path("/schools")
public class SchoolResource {

	ShcoolDAO dao = new ShcoolDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getData() {
		return new Util().getFormattedJsonString(dao.getAllSchoolInformation());
	}

	@GET
	@Path("search/{query}")
	@Produces(MediaType.APPLICATION_JSON)
	public String findByName(@PathParam("query") String query) {

		return new Util().getFormattedJsonString(dao.findByName(query));

	}
}
