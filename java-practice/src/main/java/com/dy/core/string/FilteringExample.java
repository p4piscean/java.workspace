package com.dy.core.string;

import java.util.List;
import java.util.*;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilteringExample {

	Predicate<Integer> isEven = i -> i % 2 == 0;
	Predicate<Integer> isOdd = i -> i % 2 == 1;

	Predicate<Account> isActive = a -> a.getStatus() == AccountStatus.ACTIVE;

	static Predicate<Employee> isEmployeeActive = e -> e.getStatus() == EmployeeStatus.ACTIVE;
	static Predicate<Employee> isAccountActive = e -> e.getAccount().getStatus() == AccountStatus.ACTIVE;

	public static void main(String... args) {
		List<Employee> employeeList = getEmployees();

		// Active employees
		String result = employeeList.stream().filter(isEmployeeActive).map(e -> e.getName())
				.collect(Collectors.joining(",", "[", "]"));

		System.out.println("Active employees = " + result);

		// Active employees with active accounts
		result = employeeList.stream().filter(isEmployeeActive.and(isAccountActive)).map(e -> e.getName())
				.collect(Collectors.joining(",", "[", "]"));

		System.out.println("Active employees with active accounts = " + result);

		Map<Department, Set<Employee>> wellPaidEmployeesByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.toSet()));
//groupingBy(String::length, toCollection(TreeSet::new))
//groupingBy(String::length, filtering(s -> !s.contains("c"), toList()))
	}

	private static List<Employee> getEmployees() {
		return Stream.of(new Employee("Sara", new Department("Admin"), 3000, new Account()),
				new Employee("Joe", new Department("IT"), 1000, new Account()),
				new Employee("Mike", new Department("Account"), 2000, new Account()),
				new Employee("Tony", new Department("Account"), 1500, new Account()),
				new Employee("Linda", new Department("IT"), 5000, new Account())).collect(Collectors.toList());
	}

	private static final class Employee {
		private String name;
		private Department dept;
		private int salary;
		private EmployeeStatus status;
		private Account account;

		public Employee(String name, Department dept, int salary, Account account) {
			this.name = name;
			this.dept = dept;
			this.salary = salary;
			this.account = account;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + ", dept=" + dept + ", salary=" + salary + '}';
		}

		public EmployeeStatus getStatus() {
			return status;
		}

		public Account getAccount() {
			return account;
		}

		public String getName() {
			return name;
		}

		public Department getDept() {
			return dept;
		}
	}

	private enum EmployeeStatus {
		ACTIVE, INACTIVE;
	}

	private enum AccountStatus {
		ACTIVE, INACTIVE;
	}

	private static class Account {
		private AccountStatus status;

		public AccountStatus getStatus() {
			return status;
		}
	}

	private static class Department {
		private String name;

		public Department(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Department{" + "name='" + name + '\'' + '}';
		}

		@Override
		public boolean equals(Object o) {
			Department that = (Department) o;
			return Objects.equals(name, that.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
}
