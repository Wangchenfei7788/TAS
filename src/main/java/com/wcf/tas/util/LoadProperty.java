package com.wcf.tas.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty extends Properties {
	private static final long serialVersionUID = 1L;
	
	private static LoadProperty instance;
	
	public static LoadProperty getInstance() {
		if(instance==null) {
			instance = new LoadProperty();
		}
		return instance;
	}
	private LoadProperty() {
		InputStream is = this.getClass().getResourceAsStream("/db.properties");
		
		try {
			this.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
