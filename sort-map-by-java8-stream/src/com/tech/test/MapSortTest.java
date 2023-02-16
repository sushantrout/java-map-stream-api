package com.tech.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortTest {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<>();

		hashMap.put(1, "ONE");
		hashMap.put(2, "TWO");
		hashMap.put(3, "THREE");
		hashMap.put(4, "FOUR");
		hashMap.put(5, "FIVE");
		hashMap.put(6, "SIX");
		hashMap.put(7, "SEVEN");
		hashMap.put(9, "NINE");
		hashMap.put(8, "EIGHT");

		/**
		 * THis is responsible for sort the map by the key
		 */
		Map<Integer, String> collect = hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(e -> e.getKey(), e1 -> e1.getValue(), (e1, e2) -> e1));

		collect.forEach((key, value) -> {
			System.out.println(key + "====>" + value);
		});

		System.out.println();
		System.out.println();

		/**
		 * THis is responsible for sort the map by the value
		 */
		LinkedHashMap<Integer, String> sortByValue = hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e1 -> e1.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		sortByValue.forEach((key, value) -> {
			System.out.println(key + "====>" + value);
		});

		
		System.out.println();
		System.out.println();
		// Sort map by value of bean type

		List<Employee> employees = EmployeeDataProvider.getEmployees();
		Map<String, Employee> employeeMap = employees.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e, (e1, e2) -> e1));

		Comparator<Employee> com = (o1, o2) -> o1.getName().compareTo(o2.getName());

		employeeMap = employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(com))
				.collect(Collectors.toMap(e -> e.getKey(), e1 -> e1.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		employeeMap.forEach((key, value) -> {
			System.out.println(key + "====>" + value);
		});
	}
}
