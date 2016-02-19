package practice_collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class Demo {

	public static void main(String[] args) throws CompanyException, EmployeeException {
		ICompany company = new Company("Firmata");
		
		Employee petko = new Employee("Petkan", 20, 1000);
		Employee samara = new Employee("Samara", 50, 6000);
		
		company.addEmployee("HR", petko);
		company.addEmployee("HR", new Employee("Ainura", 28, 500));
		company.addEmployee("IT", new Employee("Mara", 22, 3000));
		company.addEmployee("IT", samara);
		company.addEmployee("Higienisti", new Employee("Ainura", 28, 10000));
		company.addEmployee("IT", new Employee("Ainura", 28, 900));
		company.addEmployee("Higienisti", new Employee("Ignat", 17, 480));
		
		company.listEmployees();
		System.out.println("Killing Ainura...");
		company.killClonings();
		company.listEmployees();
		
		
//		for (Employee e : company.getEmployees("name")) {
//			System.out.println(e);
//		}
		
//		Collection<Employee> workers = Arrays.asList(petko, samara, new Employee("Ignat", 17, 480));
//		
//		Set<Employee> set = company.getTheseThatWorkInCompany(workers);
//		for (Employee e : set) {
//			System.out.println(e);
//		}
		
	}
}
