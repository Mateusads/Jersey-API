package com.cingo.logstore.services;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.repostory.LogRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogServiceTest {

  @Mock
  private LogService logServiceMock;

  @InjectMocks
  private LogRepository repositoryMock;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }


  @Test
  void testaServiceBuscarLogPorId() {
    Log log = Log.builder().content("content").build();
    logServiceMock.add(log);
    Assertions.assertEquals(log.getContent(), logServiceMock.findById(1).getContent());

  }

  @Test
  void testaBuscarTodosOsLogs() {
    Log log1 = Log.builder().content("content1").build();
    Log log2 = Log.builder().content("content2").build();
    Log log3 = Log.builder().content("content3").build();
    logServiceMock.add(log1);
    logServiceMock.add(log2);
    logServiceMock.add(log3);

    List<Log> logs = logServiceMock.findAllOrdened();
    Assertions.assertEquals("content1", logs.get(0).getContent());
    Assertions.assertEquals("content2", logs.get(1).getContent());
    Assertions.assertEquals("content3", logs.get(2).getContent());

  }

  @Test
  void testaUpdateLog() {
    Log log = Log.builder().content("content").build();
    logServiceMock.add(log);
    log.setContent("new content");
    logServiceMock.update(log, 1);
    Assertions.assertEquals("new content", logServiceMock.findById(0).getContent());

  }

  @Test
  void testaDeleteLog() {
    Log log = Log.builder().content("content").build();
    logServiceMock.add(log);

    logServiceMock.delete(1);
    Assertions.assertEquals("", logServiceMock.findAllOrdened());

  }

}