package com.cingo.logstore.repostory;


import java.util.List;;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.cingo.logstore.entity.Log;

public class LogRepository extends Repository {

	public List<Log> findAllOrdened() {
		Query query = this.getManager().createQuery("SELECT e FROM Log e ORDER BY occurrences desc");
		return query.getResultList();
	}

	public List<Log> findById(int id){
		Query query = this.getManager().createQuery("SELECT e FROM Log e WHERE id = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public void add(Log log) {
		if (this.alreadyExists(log.getContent())) {
			Log firstLogFound = this.getLogs(log.getContent()).get(0);
			firstLogFound.newOcurrence(log.getOccurrences());
			this.update(firstLogFound);
		} else {
			super.add(log);
		}
	}
	
	private boolean alreadyExists(String content){
	    return !this.getLogs(content).isEmpty();
	}
	
	private List<Log> getLogs(String content){
	    Query query = this.getManager().createQuery("SELECT e FROM Log e WHERE content = :content");
	    query.setParameter("content", content);
	    return query.getResultList();
	}



	@Transactional
	public Response delete(int logId) {
		Log log = findById(logId).get(0);
		if(this.alreadyExists(log.getContent())){
			this.getManager().getTransaction().begin();
			Query query = this.getManager().createQuery("DELETE FROM Log WHERE id = :id");
			query.setParameter("id", log.getId());
			query.executeUpdate();
			this.getManager().getTransaction().commit();
			return Response.status(200).entity("Sucess Delete").build();
		}else
			return Response.status(404).entity("Id not found").build();
	}
}
