package by.epam.course.basic.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam.course.basic.module.Product;

import by.epam.course.basic.module.Store;

public class ManagerOfStore {

		private Store store;
		
		public ManagerOfStore() {
			super();
			this.store = new Store();			
		}
		
		public void showStoreProducts(){
			ArrayList<Product> temp = store.getProducts();
			int i = 1;
			for (Product product : temp){
				System.out.println("#"+i + " Product:");
				System.out.println("	Category: "+ product.getCategory());
				System.out.println("	ID: "+ product.getManufactorID());
				System.out.println("	Date: "+ product.getCreationDate());
				System.out.println("	Annotation: "+ product.getAnnotation());
				i++;
			}
		}
		
		public void addProductToStore(Product prod){
			store.addProduct(prod);
		}
		
		public void deleteProductFromStore(int index){
			store.deleteProduct(index);
		}
		
		public Product findProductByID(int ID){
			return store.findProductByID(ID);
		}
		public int getGoodCount(){
			return store.getSize();
		}
		public void saveToFile(){
			store.addToFile();
		}
		
		public void findByParameter(String t1, Integer t2, String t3){
			boolean check;
			List<Product> temp = new ArrayList<Product>();
			System.out.println("Finded the following products with parameters " + t1 + " " + t2 +  " " + t3 + ":" );
			for (int i = 0; i < this.getGoodCount(); i++){
				check = true;
				if (t1 !=null){
					if (!store.getProducts().get(i).getCategory().equals(t1)){
						check = false;
					} 						
				}
				if (t2 !=null){
					if (store.getProducts().get(i).getManufactorID()!=t2){
						check = false;
					} 
				}
				if (t3 !=null){
					if (!store.getProducts().get(i).getCreationDate().equals(t3)){
						check = false;			
					} 
				}
				if (check){
					temp.add(store.getProducts().get(i));					
				}
			}
			
			
			Comparator<Product> comporator = new Comparator<Product>() {
				
				@Override
				public int compare(Product o1, Product o2) {

					return (o1.getManufactorID()-o2.getManufactorID());
				}
			};
			
			Collections.sort(temp, comporator);
			
			for (int i = 0 ; i < temp.size(); i++){
				System.out.println(temp.get(i));
			}
		}
}
