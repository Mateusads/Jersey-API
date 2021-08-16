package com.cingo.logstore.services;


import com.cingo.logstore.entity.Log;
import com.cingo.logstore.repostory.LogRepository;
import com.cingo.logstore.repostory.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class LogServiceTeste {

    private static final Log newLog = Log.builder()
            .content("content")
            .build();

    @InjectMocks
    private LogService logServiceMock;

    @Mock
    private LogRepository logRepository;

    @Mock
    private Repository repositoryMock;

    @Test
    void testaServiceBuscarLogPorId() {

        logServiceMock.add(newLog);
        logRepository.findById(1);
        verify(logRepository, times(1))
                .add(newLog);
    }
    @Test
    void testaBuscarTodosOsLogs() {
        logServiceMock.add(newLog);
        newLog.setContent("content2");
        logServiceMock.add(newLog);

        logRepository.findAllOrdened();
        verify(logRepository, times(2))
                .add(newLog);
    }

    @Test
    void testaUpdateLog() {
        logServiceMock.add(newLog);
        newLog.setContent("content2");
        logRepository.update(newLog);

        verify(logRepository, times(1))
                .add(newLog);
    }

    @Test
    void testaDeleteLog() {
        logServiceMock.add(newLog);

        logRepository.delete(newLog);

        verify(logRepository, times(1))
                .add(newLog);
    }

}