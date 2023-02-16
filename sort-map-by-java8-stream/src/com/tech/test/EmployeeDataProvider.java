package com.tech.test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataProvider {
	public static List<Employee> getEmployees( ) {
		List<Employee> employees = new ArrayList<Employee>();
		Employee lipuna = new Employee(1, "lipuna");
		Employee likuna = new Employee(1, "likuna");
		Employee chikuna = new Employee(1, "chikuna");
		Employee muna = new Employee(1, "muna");
		Employee miku = new Employee(1, "miku");
		Employee lika = new Employee(1, "lika");
		
		employees.add(lipuna);
		employees.add(likuna);
		employees.add(chikuna);
		employees.add(muna);
		employees.add(miku);
		employees.add(lika);
		
		return employees;
	}
}
