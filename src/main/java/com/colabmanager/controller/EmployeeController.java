//EmployeeController.java
package com.colabmanager.controller;

import com.colabmanager.model.Employee;
import com.colabmanager.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        // Log do IP e detalhes da requisição
        System.out.println("Request from IP: " + request.getRemoteAddr());
        System.out.println("Received Employee object: " + employee.toString());

        Employee savedEmployee = employeeRepository.save(employee);

        // Log dos detalhes da resposta
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response body: " + savedEmployee.toString());

        return savedEmployee;
    }

    @GetMapping
    public List<Employee> getEmployeeList() {
        // Log do IP e detalhes da requisição
        System.out.println("Request from IP: " + request.getRemoteAddr());

        List<Employee> employees = employeeRepository.findAll();

        // Log dos detalhes da resposta
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response body: " + employees.toString());

        return employees;
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        // Log do IP e detalhes da requisição
        System.out.println("Request from IP: " + request.getRemoteAddr());

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employee = employeeOptional.orElse(null);

        // Log dos detalhes da resposta
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response body: " + (employee != null ? employee.toString() : "null"));

        return employee;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        // Log do IP e detalhes da requisição
        System.out.println("Request from IP: " + request.getRemoteAddr());
        System.out.println("Updating employee with ID: " + id);
        System.out.println("Request body: " + updatedEmployee.toString());

        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            existingEmployeeOptional.get();
            Employee existingEmployee;
            existingEmployee = employeeRepository.save(updatedEmployee);

            // Log dos detalhes da resposta
            System.out.println("Response status: " + response.getStatus());
            System.out.println("Response body: " + existingEmployee.toString());

            return ResponseEntity.ok(existingEmployee);
        } else {
            // Log dos detalhes da resposta
            System.out.println("Response status: " + response.getStatus());
            System.out.println("Response body: Employee with ID " + id + " not found.");

            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        // Log do IP e detalhes da requisição
        System.out.println("Request from IP: " + request.getRemoteAddr());
        System.out.println("Deleting employee with ID: " + id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeRepository.delete(employee);

            // Log da ação
            System.out.println("Employee with ID " + id + " deleted successfully.");
            // Log dos detalhes da resposta
            System.out.println("Response status: " + ResponseEntity.noContent().build());

            return ResponseEntity.noContent().build(); // Retorna status 204 (No Content)
        } else {
            // Log da ação
            System.out.println("Employee with ID " + id + " not found.");

            // Log dos detalhes da resposta
            System.out.println("Response status: " + ResponseEntity.notFound().build());
            return ResponseEntity.notFound().build();
        }
    }
}