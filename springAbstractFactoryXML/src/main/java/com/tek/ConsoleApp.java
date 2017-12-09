package com.tek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext appCtx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ClientBean clientBean =
                (ClientBean)appCtx.getBean("clientBean");

        clientBean.invokeParser("xmlParser");
        clientBean.invokeParser("jsonParser");
    }
}