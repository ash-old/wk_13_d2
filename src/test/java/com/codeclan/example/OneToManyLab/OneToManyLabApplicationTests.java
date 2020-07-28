package com.codeclan.example.OneToManyLab;

import com.codeclan.example.OneToManyLab.models.Department;
import com.codeclan.example.OneToManyLab.models.Employee;
import com.codeclan.example.OneToManyLab.models.Project;
import com.codeclan.example.OneToManyLab.repositories.DepartmentRepository;
import com.codeclan.example.OneToManyLab.repositories.EmployeeRepository;
import com.codeclan.example.OneToManyLab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToManyLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateEmployeeAndDepartment(){
		Department department = new Department("Accounts");
		departmentRepository.save(department);
		Employee employee = new Employee("John", "Smith", 12345, department);
		employeeRepository.save(employee);
	}

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("Accounts");
		departmentRepository.save(department);
		Employee employee = new Employee("John", "Smith", 12345, department);
		employeeRepository.save(employee);
		Project project = new Project("End of year Accounts", 15);
		projectRepository.save(project);
		project.addEmployee(employee);
		projectRepository.save(project);
	}


}
