package com.lorinmelek.spring_rest_api.config;

import com.lorinmelek.spring_rest_api.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

//bean yapısı olurturucak dummy veri için
@Configuration
public class AppConfig
{
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Lorin", "Vural"));
        employeeList.add(new Employee("2", "Lorin", "melek"));
        employeeList.add(new Employee("3", "melek", "Vural"));
        employeeList.add(new Employee("4", "melek", "lorin"));
        employeeList.add(new Employee("5", "Lorin", "Vural"));

        return employeeList;
    }
}
