package com.cingo.logstore.services;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.repostory.LogRepository;
import com.cingo.logstore.services.exceptions.DataBaseException;
import com.cingo.logstore.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LogService {

    private final LogRepository repository;

    public List<Log> findAllOrdened() {
        List<Log> entity = repository.findAllOrdened();
        if (!entity.isEmpty()) {
            return entity;
        }
        throw new ResourceNotFoundException("Não foi possível buscar os dados solicitados ");
    }

    public Log findById(int id) {
        try {
            Optional<Log> logOptional = this.repository.findById(id);
            return logOptional.get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Não foi possível buscar os dados solicitados ");
        }
    }

    public void add(Log newLog) {
        try {
            repository.add(newLog);
        } catch (Exception e) {
            throw new DataBaseException("Não foi possível adicionar um novo Log ");
        }
    }

    public Log update(Log logCurrent, int id) {
        try {
            Log current = findById(id);
            current.setContent(logCurrent.getContent());
            repository.update(current);
            return current;
        } catch (Exception e) {
            throw new DataBaseException("Não foi possível atualizar esse Log ");
        }
    }

    public void delete(int id) {
        Log log = findById(id);
        try {
            repository.delete(log);
        } catch (Exception e) {
            throw new DataBaseException("Não foi possível remover esse Log ");
        }
    }
}
