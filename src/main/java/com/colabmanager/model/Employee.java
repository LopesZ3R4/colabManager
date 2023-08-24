//Employee.java
package com.colabmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee") // Adicionei a anotação @Table com o nome da tabela no banco de dados
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private Long id;
    @Column(name = "name") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private String name;
    @Column(name = "codfuncao") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private Integer codfuncao;
    @Column(name = "salary") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private double salary;
    @Column(name = "dtnascimento") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private LocalDate dtnascimento;
    @Column(name = "dtadmissao") // Adicionei a anotação @Column com o nome da coluna no banco de dados
    private LocalDate dtadmissao;

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCodfuncao() {
        return codfuncao;
    }

    public void setCodfuncao(Integer codfuncao) {
        this.codfuncao = codfuncao;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(LocalDate dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public LocalDate getDtadmissao() {
        return dtadmissao;
    }

    public void setDtadmissao(LocalDate dtadmissao) {
        this.dtadmissao = dtadmissao;
    }
}