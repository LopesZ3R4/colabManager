//EmployeeController.java
package com.colabmanager.controller;

import com.colabmanager.model.Employee;
import com.colabmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println("Received Employee object: " + employee.toString()); // Imprime o objeto no console
        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null); // Retorna null se não for encontrado
    }
}

