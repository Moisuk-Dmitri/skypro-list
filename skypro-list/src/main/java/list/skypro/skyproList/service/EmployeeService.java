package list.skypro.skyproList.service;

import list.skypro.skyproList.domain.Employee;
import list.skypro.skyproList.domain.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);

    public Employee removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);

    public List<Employee> getEmployeesList();
}
