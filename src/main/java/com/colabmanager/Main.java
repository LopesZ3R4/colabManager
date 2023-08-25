//main.java
package com.colabmanager;

import com.colabmanager.controller.EmployeeController;
import com.colabmanager.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication(scanBasePackages={"com.*"})
@EntityScan( basePackages = {"com.*"} )
@EnableJpaRepositories( basePackages = {"com.*"} )

public class Main {
//    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(Main.class, args);
//
//        // Injete o seu EmployeeController aqui
//        EmployeeController employeeController = context.getBean(EmployeeController.class);
//
//        // Criar um funcionário usando o construtor
//        Employee employee = new Employee(); // Adicionei o construtor sem argumentos
//        employee.setName("Joao"); // Usei o ponto e vírgula para separar as chamadas dos métodos
//        employee.setCodfuncao(10);
//        employee.setSalary(5000.0);
//        employee.setDtnascimento(LocalDate.of(1990, 1, 1)); // Usando LocalDate
//        employee.setDtadmissao(LocalDate.of(2023, 8, 23)); // Usando LocalDate
//
//        // Salvar o novo funcionário usando o serviço do controller
//        Employee savedEmployee = employeeController.createEmployee(employee); // Usei a variável employee em vez de newEmployee
//
//        // Exibir os detalhes do funcionário
//        System.out.println("Detalhes do Funcionário:");
//        System.out.println("ID: " + savedEmployee.getId()); // Usei a variável savedEmployee em vez de newEmployee
//        System.out.println("Nome: " + savedEmployee.getName());
//        System.out.println("Função: " + savedEmployee.getCodfuncao());
//        System.out.println("Salário: " + savedEmployee.getSalary());
//        System.out.println("Data de Nascimento: " + savedEmployee.getDtnascimento());
//        System.out.println("Data de Admissão: " + savedEmployee.getDtadmissao());
//    }
public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Main.class, args);

    // Injete o seu EmployeeController aqui
    EmployeeController employeeController = context.getBean(EmployeeController.class);

    // Obter o funcionário pelo ID (no caso, ID 1)
    Long employeeId = 1L;
    Employee retrievedEmployee = employeeController.getEmployeeById(employeeId);

    if (retrievedEmployee != null) {
        // Exibir os detalhes do funcionário
        System.out.println("Detalhes do Funcionário:");
        System.out.println("ID: " + retrievedEmployee.getId());
        System.out.println("Nome: " + retrievedEmployee.getName());
        System.out.println("Função: " + retrievedEmployee.getCodfuncao());
        System.out.println("Salário: " + retrievedEmployee.getSalary());
        System.out.println("Data de Nascimento: " + retrievedEmployee.getDtnascimento());
        System.out.println("Data de Admissão: " + retrievedEmployee.getDtadmissao());
    } else {
        System.out.println("Funcionário com ID " + employeeId + " não encontrado.");
    }
}
}