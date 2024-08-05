package hm.skypro.SkyproListSet.service;

import hm.skypro.SkyproListSet.domain.Employee;
import hm.skypro.SkyproListSet.exception.EmployeeAlreadyAddedException;
import hm.skypro.SkyproListSet.exception.EmployeeNotFoundException;
import hm.skypro.SkyproListSet.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int maxEmployeeNumber = 2;

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() >= maxEmployeeNumber) {
            throw new EmployeeStorageIsFullException("ArrayIsFull");
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
            }
        }

        employees.add(new Employee(firstName, lastName));
        return employees.getLast();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                employees.remove(i);
                return employee;
            }
        }

        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                return employees.get(i);
            }
        }

        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employees;
    }
}
