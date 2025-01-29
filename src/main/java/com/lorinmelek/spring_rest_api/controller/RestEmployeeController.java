package com.lorinmelek.spring_rest_api.controller;

import com.lorinmelek.spring_rest_api.model.Employee;
import com.lorinmelek.spring_rest_api.model.UpdateEmployeeRequest;
import com.lorinmelek.spring_rest_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController
{
    @Autowired//controller ve service bağlandı/ service in beanini çekebiliyorum.
    private EmployeeService employeeService;
    @GetMapping("/list")
    public List<Employee> getAllEmployeeList()
    {
        employeeService.getAllEmployeeList();//aldığım http requesti servise yönlnendirmek için yaızyorum bunu.
        return employeeService.getAllEmployeeList();//srviceten gelen employee bililerini alıyoruz.
    }
    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id)
    {//id si aracılığıyla rquest atabiliyoruz bu sayede.
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/with-params")
    public  List <Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false/*bunu false verirsen bu parametreyi almak zorunda olmaz.*/) String firstName,
                                                  @RequestParam(name ="lastName", required = false) String lastName)
    {
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }
    @PostMapping(path = "/save-employee")//employee ekliycem veriye
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }
    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id", required = true) String id)
    {
        return employeeService.deleteEmployee(id);
    }
    @PutMapping(path = "/update-employee/{id}")//update employee yapıyorum.
    public Employee updateEmployee(@PathVariable(name = "id", required = true) String id, @RequestBody UpdateEmployeeRequest request)
    {
     return employeeService.updateEmployee(id, request);
    }
}
