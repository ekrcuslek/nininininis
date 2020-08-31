package service;

import dao.File1DAO;
import domain.File1;

public class File1Service {
	File1DAO fd= new File1DAO();
	
	
	public void newFile(File1 file) {
		fd.newFile(file);
	}
	
}
