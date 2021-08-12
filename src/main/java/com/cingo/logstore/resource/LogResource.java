package com.cingo.logstore.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.repostory.LogRepository;

@Path("log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {

    @Context
    private HttpServletRequest httpRequest;
    private LogRepository repository = new LogRepository();

    @GET
    public List<Log> getLogs() {
        return this.repository.findAllOrdened();
    }

    @GET
    @Path("/{id}/")
    public List<Log> getLogById(@PathParam("id") int id) {
        return this.repository.findById(id);
    }

    @DELETE
    @Path("/delete/{id}/")
    public Response deleteLogs(@PathParam("id") int id) {
        Response response = this.repository.delete(id);
        return response;

    }
}