package com.cingo.logstore.entity.factory.impl;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.entity.factory.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import org.mockito.Mock;

class DefaultLogFactoryTest {

    @Mock
    LogFactory logFactory = new DefaultLogFactory();

    @Test
    public void testeDefaultLog() {
        Log log = logFactory.build("content", 1);
        Assertions.assertEquals("content", log.getContent());
        Assertions.assertEquals(1, log.getOccurrences());

    }

}