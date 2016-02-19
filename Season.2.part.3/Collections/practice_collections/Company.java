package practice_collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Company implements ICompany {
	// department name
	private Map<String, Set<Employee>> departments;
	private String name;
	
	public Company(String name) {
		this.name = name;
		this.departments = new HashMap<String, Set<Employee>>();
	}
	

	@Override
	public void addEmployee(String department, Employee e) throws CompanyException {
		if (department != null && e != null && !department.trim().equals("")) {
			if (!this.departments.containsKey(department)) {
				this.departments.put(department, new HashSet<Employee>());
			}
			
			this.departments.get(department).add(e);
		}
		else {
			throw new CompanyException("Invalid data for add employee");
		}
	}
	
	@Override
	public void listEmployees() {
		for (String department : departments.keySet()) {
			System.out.println("Department : " + department);
			
			Set<Employee> employeesThatWorkInThisDepartment = departments.get(department);
			for (Employee e : employeesThatWorkInThisDepartment) {
				System.out.println(e);
			}
		}
	}
	
	public void killClonings() {
		Set<Employee> employees = new HashSet<Employee>();
		
		for (String department : departments.keySet() ) {
			Set<Employee> employeesInDepartmente = departments.get(department);
			
			for (Iterator<Employee> it = employeesInDepartmente.iterator(); it.hasNext();) {
				Employee employeeInDepartment = it.next();
				
				if (employees.add(employeeInDepartment) == false) {
					it.remove();
				}
			}
		}
	}

	public SortedSet<Employee> getTheseThatWorkInCompany(Collection<Employee> employees) {
		TreeSet<Employee> employeesThatWorkInCompany = new TreeSet<Employee>(
				(e1,e2) -> e1.getName().compareTo(e2.getName()));
		
		for (Iterator<Employee> it = employees.iterator(); it.hasNext();) {
			Employee emp = it.next();
			
			for (String department : departments.keySet()) {
				Set<Employee> employeesInDepartment = departments.get(department);
				
				if (employeesInDepartment.contains(emp)) {
					employeesThatWorkInCompany.add(emp);
				}
			}
		}
		
		return employeesThatWorkInCompany;
	}
	
	public SortedSet<Employee> getEmployees(String sortByWhat) throws CompanyException {
		if (sortByWhat != null) {
			SortedSet<Employee> allEmployees = new TreeSet<Employee>((e1,e2)-> {
				if (sortByWhat.equals("salary")) {
					return e1.getSalary() - e2.getSalary();
				}
				if (sortByWhat.equals("name")) {
					return e1.getName().compareTo(e2.getName());
				}
				
				return e1.getAge() - e2.getAge();
			});
			
			for (String department : departments.keySet()) {
				Set<Employee> employeesInThisDepartment = departments.get(department);
				allEmployees.addAll(employeesInThisDepartment);
			}
			
			return allEmployees;
		}
		else 
			throw new CompanyException("Invalid sorting parameter");
	}
	
}
