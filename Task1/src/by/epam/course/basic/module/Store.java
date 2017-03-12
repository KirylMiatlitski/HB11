package by.epam.course.basic.module;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.course.basic.DAO.FileWorker;
import by.epam.course.basic.DAO.FileWorkerFactory;

public final class Store {

	private ArrayList<Product> products;
	
	public Store() {
		products = new ArrayList<>();
		loadStore();
	}
	
	
	
	public ArrayList<Product> getProducts() {
		return products;
	}



	public  boolean addProduct(Product product){
		
		products.add(product);
		return true;		
	}
	
	public  boolean deleteProduct(int i){
		products.remove(i);
		
		return true;								
	}
	
	public  Product findProductByID(int ID){
		
		return products.get(ID);
		
	}
	
	public int getSize(){
		return products.size();
	}
	private void loadStore(){
		FileWorker file = FileWorkerFactory.getFileWorker();
		String goods;
		try {
			goods = file.read();
			
			Pattern pattern = Pattern.compile("([^\"]*)", Pattern.DOTALL);
			Matcher match = pattern.matcher(goods);
			int i = 1;
			String category = "";
			Integer ID = 0;
			String creationDate = "";
			String annotation = "";
			while (match.find()){				
				if ((match.group(1).trim().length()!=0) ){
					switch (i){
					case 1: 
						category = match.group(1).trim();
						i++;
						break;
					case 2:
						ID =  Integer.parseInt(match.group(1).trim());
						i++;
						break;
					case 3: 
						creationDate = match.group(1).trim();
						i++;
						break;
					case 4: 
						annotation =  match.group(1).trim();
						i=1;						
						this.products.add(new Product(category, ID, creationDate , annotation));
						break;	
					}									
				}			
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public  void addToFile(){
		FileWorker file = FileWorkerFactory.getFileWorker();
		String result = "";
		for (Product temp : products){
			result = result + "\""+temp.getCategory()+"\" \""+temp.getManufactorID()+"\" \""+temp.getCreationDate()+"\" \""+temp.getAnnotation()+"\""+"\n";
		}
		file.write(result);
	}
	
	
}
