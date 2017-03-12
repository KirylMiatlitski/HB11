package by.epam.course.basic.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWorker {

		private String filePath = "src/test.txt";
		private File file;
		public FileWorker() {		
			
			file = new File(filePath);
		}
		
		
		public String getFilePath() {
			return filePath;
		}		

		public File getFile() {
			return file;
		}
		
		public  String read() throws FileNotFoundException {
		    
		    StringBuilder sb = new StringBuilder();
		 
		    if(!file.exists()){
	            throw new FileNotFoundException() ;
	        }
		    try {
		       
		        BufferedReader in = new BufferedReader(new FileReader(this.file.getAbsoluteFile()));
		        try {
		            String s;
		            while ((s = in.readLine()) != null) {
		                sb.append(s);
		                sb.append("\n");
		            }
		        } finally {
		            in.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
		    return sb.toString();
		}
		
		public  void write(String text) {
		    try {
		    	if(!file.exists()){
		            file.createNewFile();
		        }
		    	
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		 
		        try {
		            out.println(text);
		        } finally {
		            out.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
		}
		
		
}
