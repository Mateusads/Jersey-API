package com.cingo.logstore.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.resource.dto.LogRequestDTO;
import com.cingo.logstore.resource.dto.LogResponseDTO;
import com.cingo.logstore.resource.mapper.LogMapper;
import com.cingo.logstore.services.LogService;

@Path("log")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {

    @Context
    private HttpServletRequest httpRequest;
    private LogService service = new LogService();

    @GET
    public List<LogResponseDTO> getLogs() {
        List<Log> logs = this.service.findAllOrdened();
        return LogMapper.toDTOs(logs);
    }

    @GET
    @Path("/{id}/")
    public LogResponseDTO getLogById(@PathParam("id") int id) {
        Log log = service.findById(id);
        return LogMapper.toDTO(log);
    }

    @POST
    public LogResponseDTO save(LogRequestDTO logRequestDTO) {
        Log newLog = LogMapper.toEntity(logRequestDTO);
        service.add(newLog);
        return LogMapper.toDTO(newLog);
    }

    @PUT
    @Path("/{id}/")
    public LogResponseDTO update(@PathParam("id") int id, LogRequestDTO logRequestDTO) {
        Log updateLog = LogMapper.toEntity(logRequestDTO);
        updateLog = service.update(updateLog, id);
        return LogMapper.toDTO(updateLog);
    }

    @DELETE
    @Path("/{id}/")
    public Response deleteLogs(@PathParam("id") int id) {
        this.service.delete(id);
        return Response.noContent().build();
    }
}