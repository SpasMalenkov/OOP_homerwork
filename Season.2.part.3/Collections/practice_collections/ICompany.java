package practice_collections;

import java.util.Collection;
import java.util.SortedSet;

public interface ICompany {

	void addEmployee(String department, Employee e) throws CompanyException;

	void listEmployees();
	
	public SortedSet<Employee> getEmployees(String sortByWhat) throws CompanyException;
	
	public SortedSet<Employee> getTheseThatWorkInCompany(Collection<Employee> employees);
	public void killClonings();
}