package by.epam.course.basic.main;

import by.epam.course.basic.controller.ManagerOfStore;
import by.epam.course.basic.view.View;

/**
 * @author Kiryl_Miatlitski
 *
 * Date: 12 March 2017
 * 
 * Task: –азработать консольное приложение, работающее с “оварами в —кладе. 
 *  аждый “овар это: “овар(категори€, код производител€, дата выпуска, аннотацию).
 */
public class Task1 {

	public static void main(String[] args) {
		try{
			// если кто-то смотрит мой код, не делайте как €, можно было просто захардкодить
			// € убил на view кучу времени. хнык хнык =(
			View view = new View();
			view.doAction();
			
			// делайте вот так
			// —ортировка по ID
			ManagerOfStore manager = new ManagerOfStore();
			manager.findByParameter("Milk", null, null);
			manager.findByParameter("Milk", null, "9/3/2017");
			
		} catch(Exception e){
			System.out.println("Sorry, something went wrong");
		}
		
	}

}
