package com.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.test.AppConfig.class)
public class ServiceLocatorFactoryExample {

    @Autowired
    private ParserService parserService;

    @Test
    public void testParserFactory() {
        parserService.doParse("calling Json Parser", ParserType.JSON);
        parserService.doParse("Calling XML Parser", ParserType.XML);
    }
}


