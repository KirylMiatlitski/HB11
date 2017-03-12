package by.epam.course.basic.module;

public class StoreFactory {
	private static Store store;
	private StoreFactory(){
		store = new Store();
	}
	public static Store getStore(){
		return store;
	}
}
