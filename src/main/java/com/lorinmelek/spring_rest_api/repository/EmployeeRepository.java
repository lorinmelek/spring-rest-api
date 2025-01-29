package com.lorinmelek.spring_rest_api.repository;

import com.lorinmelek.spring_rest_api.model.Employee;
import com.lorinmelek.spring_rest_api.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository
{
    @Autowired//configde oluştuurduğumuz datayı bağlıyoruz.
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList()
    {
        return employeeList;
    }
    public Employee getEmployeeById(String id)
    {// istenilen id ile sorgulama yapılınca arama burda yapılıyor. bulunan empployee return ediyoruz.
        Employee findEmployee = null;
        for (Employee employee : employeeList)
        {
            if(employee.getId().equals(id))
            {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName)
    {
        List<Employee> employeeWithParams = new ArrayList<>();
    if(firstName == null && lastName == null)
        {
            return employeeList;
        }
        for(Employee employee : employeeList)
        {
            if(firstName != null && lastName != null)
            {
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName))
                {
                    employeeWithParams.add(employee);
                }
            }
            if(firstName != null && lastName == null)
            {
                if (employee.getFirstName().equals(firstName))
                {
                    employeeWithParams.add(employee);
                }
            }
            if(firstName == null && lastName != null)
            {
                if (employee.getLastName().equals(lastName))
                {
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }
    public Employee saveEmployee(Employee newEmployee)
    {
        employeeList.add(newEmployee);
        return newEmployee;
    }
    public boolean deleteEmployee(String id)
    {
        Employee deleteEmployee = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId().equals(id))
            {
                deleteEmployee = employee;
                break;
            }
        }
        if(deleteEmployee == null){
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;
    }
    private Employee findEmployeeById(String id){
        Employee findEmployee = null;
        for(Employee employee : employeeList)
        {
            if(employee.getId().equals(id))
            {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }
    public Employee updateEmployee(String id, UpdateEmployeeRequest request)
    {
        Employee findEmployee = findEmployeeById(id);
        if(findEmployee != null )
        {
            deleteEmployee(id);
            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(request.getFirstName());
            updatedEmployee.setLastName(request.getLastName());

            return saveEmployee(updatedEmployee);//save the new employee to data.
        }
        return null;
    }
}
