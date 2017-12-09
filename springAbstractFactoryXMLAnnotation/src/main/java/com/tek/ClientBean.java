package com.tek;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean {

	@Autowired
	private IParseFactory parseFactory;

	public void invokeParser(String parserName) {
		IParser parser = this.parseFactory.getParser(parserName);
		parser.parse();
	}

}
