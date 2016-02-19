package practice_collections;

public class Employee {

	private static final int MIN_SALARY = 220;
	private static final int MIN_AGE_TO_WORK = 16;
	private static long lastId = 1;

	private String name;
	private int age;
	private int salary;
	private long id;

	public Employee(String name, int age, int salary) throws EmployeeException {
		setName(name);
		setAge(age);
		setSalary(salary);

		this.id = lastId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws EmployeeException {
		if (name != null && name.length() > 0)
			this.name = name;
		else
			throw new EmployeeException("Name is invalid");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws EmployeeException {
		if (age > MIN_AGE_TO_WORK && age > this.age)
			this.age = age;
		else
			throw new EmployeeException("Name is invalid.");
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) throws EmployeeException {
		if (salary > MIN_SALARY)
			this.salary = salary;
		else
			throw new EmployeeException("Salary is invalid.");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}
