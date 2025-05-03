package com.yep.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WmsApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(WmsApplication.class, args);
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
