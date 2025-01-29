package com.lorinmelek.spring_rest_api.services;

import com.lorinmelek.spring_rest_api.model.Employee;
import com.lorinmelek.spring_rest_api.model.UpdateEmployeeRequest;
import com.lorinmelek.spring_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired //repoya bağlamak için
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployeeList(){
        // controllerin hepsi burda gerçekleşiyor.
        return employeeRepository.getAllEmployeeList();//employeerepodaki employeelerin hespini döndürüyoruz.
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }
    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }
    public Employee saveEmployee(Employee newEmployee){
        return employeeRepository.saveEmployee(newEmployee);
    }
    public boolean deleteEmployee(String id){
        return employeeRepository.deleteEmployee(id);
    }
    public Employee updateEmployee(String id, UpdateEmployeeRequest request){
        return employeeRepository.updateEmployee(id, request);
    }
}
