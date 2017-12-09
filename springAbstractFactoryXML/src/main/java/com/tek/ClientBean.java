package com.tek;

public class ClientBean {

    private IParseFactory parseFactory;

    public void setParseFactory(IParseFactory parseFactory) {
        this.parseFactory = parseFactory;
    }



    public void invokeParser(String parserName) {
        IParser parser = this.parseFactory.getParser(parserName);
        // use this service object to go ahead with the business logic
        parser.parse();
    }


}
