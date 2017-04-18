package Trees;

import java.util.ArrayList;
import java.util.List;

public class FindCommonManager {
	static Employee findCommonManager(Employee root, Employee emp1, Employee emp2) {
		if(root==null || emp1==null ||emp2==null)
			return null;
		CommonManager commonManager = new CommonManager();
		CheckIfFound check = new CheckIfFound(false,false);
		findCommonManagerHelper(root, emp1, emp2, check, commonManager);
		return commonManager.commonManager;
	}
	
	static CheckIfFound findCommonManagerHelper(Employee root, Employee emp1, Employee emp2, CheckIfFound check, CommonManager commonManager) {
		
		
//		System.out.println(root.name);
		for(Employee emp: root.employees) {
			CheckIfFound temp = new CheckIfFound(false,false); 
			if(emp.name.equals(emp1.name)) {
				temp.emp1 = true;
				check.emp1 = true;
			}
			if(emp.name.equals(emp2.name)) {
				temp.emp2 = true;
				check.emp2 = true;
			}
			CheckIfFound check1 = findCommonManagerHelper(emp, emp1, emp2, temp, commonManager);
			if(commonManager.commonManager!=null)
				return check;
//			System.out.println(emp.name+" "+check1.emp1+" "+check1.emp2);
			if(check1.emp1)
				check.emp1 = true;
			if(check1.emp2)
				check.emp2 = true;
			if(check.emp1 && check.emp2) {
				commonManager.commonManager = root;
//				System.out.println("Manager "+commonManager.commonManager.name);
				return check;
			}
		}
		return check;
	}
	
	public static void main(String[] args) {
		Employee Bill = new Employee("Bill");
		Employee Dom = new Employee("Dom");
		Employee Samir = new Employee("Samir");
		Employee Michael = new Employee("Michael");
		Employee Bob = new Employee("Bob");
		Employee Peter = new Employee("Peter");
		Employee Porter = new Employee("Porter");
		Employee Milton = new Employee("Milton");
		Employee Nina = new Employee("Nina");
		Employee Harsha = new Employee("Harsha");
		Bill.employees.add(Dom);
		Bill.employees.add(Samir);
		Bill.employees.add(Michael);
		Dom.employees.add(Bob);
		Dom.employees.add(Peter);
		Dom.employees.add(Porter);
		Peter.employees.add(Milton);
		Peter.employees.add(Harsha);
		Harsha.employees.add(Nina);
		System.out.println((findCommonManager(Bill, Milton, Nina).name));
		System.out.println((findCommonManager(Bill, Nina, Porter).name));
		System.out.println((findCommonManager(Bill, Nina, Samir).name));
		System.out.println((findCommonManager(Bill, Peter, Nina).name));
	}
}


class Employee {
	String name;
	List<Employee> employees;
	
	Employee(String name) {
		this.name = name;
		employees = new ArrayList<Employee>();
	}
}

class CheckIfFound {
	boolean emp1;
	boolean emp2;
	Employee commonManager;
	CheckIfFound(boolean emp1, boolean emp2) {
		this.emp1 = emp1;
		this.emp2 = emp2;
		commonManager = null;
	}
}

class CommonManager {
	Employee commonManager;
	CommonManager() {
		this.commonManager = null;
	}
}