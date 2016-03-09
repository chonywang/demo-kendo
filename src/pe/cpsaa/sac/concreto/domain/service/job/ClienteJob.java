package pe.cpsaa.sac.concreto.domain.service.job;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class ClienteJob {

	@Autowired
	private ServletContext servletContext;
	
	Logger logger = Logger.getLogger(ClienteJob.class);

	@Scheduled(cron = "0 0 0/1 1/1 * ?")
	public void cerrarLote() throws Exception {
		System.out.println("Correr Job");
	}
	
	
	
	
}
