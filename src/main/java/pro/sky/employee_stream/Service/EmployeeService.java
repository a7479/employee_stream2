package pro.sky.employee_stream.Service;


import org.springframework.stereotype.Service;
import pro.sky.employee_stream.Employee;
import pro.sky.employee_stream.Exception.EmployeeAlreadyAddedException;
import pro.sky.employee_stream.Exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> staff = new ArrayList<>();


    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Double salary) {

        Employee temp = new Employee(firstName, lastName, departmentId,salary);
        if (staff.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }

        staff.add(temp);
        return temp;


    }

    public Employee removeEmployee(String firstName, String lastName, Integer departmentId, Double salary) {
        Employee temp = new Employee(firstName, lastName, departmentId,salary);
        if (staff.contains(temp)) {
            staff.remove(temp);
            return temp;
        }

        throw new EmployeeAlreadyAddedException();


    }

    public Employee findEmployee(String firstName, String lastName, Integer departmentId, Double salary) {
        Employee temp = new Employee(firstName, lastName, departmentId,salary);
        if (staff.contains(temp)) {
            return temp;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(staff);
    }
}

