package com.app.waylearn.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentServiceImp implements DocumentService {

	private final Path rootFolder = Paths.get("uploads");
	private Date fecha = new Date();
	
	private String day = Integer.toString(fecha.getDay()+1);
	private String month = Integer.toString(fecha.getMonth()+1);
	private String year = Integer.toString(fecha.getYear()+1900);
	private String hour = Integer.toString(fecha.getHours());
	private String minute = Integer.toString(fecha.getMinutes());
	private String second = Integer.toString(fecha.getSeconds());
	
	private String Name = fecha.toString();
	
//	String name = fechaHora.format(fecha.getTime());
	
	String name = day+"-"+month+"-"+year+"-"+hour+"-"+minute+"-"+second;
	
	@Override
	public void save(MultipartFile file) throws Exception {

		String fileName = file.getOriginalFilename();
		String ext = "";
		
		int i = fileName.lastIndexOf('.');
		
		ext = fileName.substring(i);
		
		Files.copy(file.getInputStream(), this.rootFolder.resolve(name+ext) );
		
		
	}

	@Override
	public void load(String name) throws Exception {
		// TODO Auto-generated method stub
	
	}

}
