package com.example.SpringGreetingApp.controller;

import com.example.SpringGreetingApp.exception.ResourceNotFoundException;
import com.example.SpringGreetingApp.model.Employee;
import com.example.SpringGreetingApp.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*") // Allow API to be accessed from any frontend
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // GET: Retrieve all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return ResponseEntity.ok(employees);
    }

    // GET: Retrieve a specific employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = repository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}") // Corrected path
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = repository.findById(id) // Use 'repository' instead of 'employeeRepository'
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employee.setName(employeeDetails.getName());
        employee.setRole(employeeDetails.getRole());

        Employee updatedEmployee = repository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // DELETE: Remove an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
