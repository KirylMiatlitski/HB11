package by.epam.course.basic.main;

import by.epam.course.basic.controller.ManagerOfStore;
import by.epam.course.basic.view.View;

/**
 * @author Kiryl_Miatlitski
 *
 * Date: 12 March 2017
 * 
 * Task: ����������� ���������� ����������, ���������� � �������� � ������. 
 * ������ ����� ���: �����(���������, ��� �������������, ���� �������, ���������).
 */
public class Task1 {

	public static void main(String[] args) {
		try{
			// ���� ���-�� ������� ��� ���, �� ������� ��� �, ����� ���� ������ ������������
			// � ���� �� view ���� �������. ���� ���� =(
			View view = new View();
			view.doAction();
			
			// ������� ��� ���
			// ���������� �� ID
			ManagerOfStore manager = new ManagerOfStore();
			manager.findByParameter("Milk", null, null);
			manager.findByParameter("Milk", null, "9/3/2017");
			
		} catch(Exception e){
			System.out.println("Sorry, something went wrong");
		}
		
	}

}
