package com.cingo.logstore.services;


import com.cingo.logstore.entity.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import org.mockito.Mock;

class LogServiceTest {

    @Mock
    LogService logService = new LogService();

    @Test
    public void testeFindById() {
        Log newLog = Log.builder()
                .occurrences(1)
                .content("content")
                .build();

        logService.add(newLog);

        Assertions.assertEquals("content", newLog.getContent());
        Assertions.assertEquals(1, newLog.getOccurrences());

    }
}