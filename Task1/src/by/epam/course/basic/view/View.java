package by.epam.course.basic.view;

import java.util.Scanner;

import by.epam.course.basic.controller.ManagerOfStore;
import by.epam.course.basic.module.Product;

public class View {
	
	private ManagerOfStore manager;
	
	
	public Product createNewProduct(Scanner sc){
		try{
			
			String userInput = "";
			String category = "";
			Integer ID = 0;
			String date = "";
			String annotation = "";
			userInput = sc.nextLine();
			for (int i = 1; i < 5; i++){
				switch (i){
				case 1: 
					System.out.println("Category: ");
					break;
				case 2: 
					System.out.println("Manufactor ID: ");
					break;
				case 3: 
					System.out.println("Creation Date: ");
					break;
				case 4: 
					System.out.println("Annotation: ");
					break;
				
				}
				userInput = sc.nextLine();
				switch (i) {
					case 1:
						category = userInput;
						break;
					case 2:
						ID = Integer.parseInt(userInput);
						break;
					case 3:
						date = userInput;
						break;
					case 4:
						annotation = userInput;
						break;
				}
			} 
			
			
			return new Product(category, ID, date, annotation);
		}catch(Exception e){
			System.out.println("Something was wrong");
			return null;
		}
		
	}
	public View(){
		manager = new ManagerOfStore();
	}
	public int showMenu(Scanner sc){
		System.out.println("Choose one of the following points:");
		System.out.println("1. Show all products at store;");
		System.out.println("2. Add a new product");
		System.out.println("3. Take product;");
		System.out.println("4. Find products by Manufactor ID;");
		System.out.println("5. Exit from application");
		int userInput = 0;
		
	
		userInput = sc.nextInt();
		
		
		return userInput;
		
	}
	public void doAction(){
		try{
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		while (userInput != 5) {
			userInput = 0;
			userInput = showMenu(sc);
		
			switch (userInput){
			
					
			case 1:
					manager.showStoreProducts();
					break;
			case 2:
					System.out.println("Enter a new product");
					Product product = createNewProduct(sc);
					if (product != null){
						manager.addProductToStore(product);
					} 
					break;
			case 3:
					
					int index = 0;
					System.out.println("Specify the # of the product which you would like to take");
					if (sc.hasNextInt()){
						index = sc.nextInt();
					} else {
						System.out.println("Please specify the number of the product");
					}
					
					if ((index-1 > 0 ) & (index-1 < manager.getGoodCount())){
						manager.deleteProductFromStore(index-1);
					} else {
						System.out.println("Specify correct # of the product");
					}
						
					break;
			case 4:
					System.out.println("Specify the number of the product");
					int i = 0;
					if (sc.hasNextInt()){
						i = sc.nextInt();
					} else {
						System.out.println("Please specify the number of the product");
					}
					
					System.out.println(manager.findProductByID(i-1).toString());
					break;
			case 5:
					sc.close();
					manager.saveToFile();
					System.out.println("END");
					return;
			default:
					userInput = 0;
					break;
				
			}
		}
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Мы где-то промахнулись с индексом. Ничего страшного");
		}
	}

}
