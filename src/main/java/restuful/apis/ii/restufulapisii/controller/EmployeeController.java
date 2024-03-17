package restuful.apis.ii.restufulapisii.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import restuful.apis.ii.restufulapisii.entity.Employee;
import restuful.apis.ii.restufulapisii.exceptions.EmployeeNotFoundException;
import restuful.apis.ii.restufulapisii.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {

    private final EmployeeRepository empRepository;

    EmployeeController(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @GetMapping("/")
    String home() {
        return "Welcome to Employee Management System";
    }

    @GetMapping("/employees")
    List<Employee> getAll() {
        return empRepository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        
        
        return empRepository.save(newEmployee);
    }

    //getbyId
        @GetMapping("employee/{id}")
    Employee getEmpById(@PathVariable Long id){
        return empRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    //update

        @PutMapping("employee/{id}")
        Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){

            return empRepository.findById(id)
            .map(employee -> { 
                employee.setName(newEmployee.getName());
                employee.setRole(newEmployee.getRole());
            return empRepository.save(employee);
        })
            .orElseGet(() -> {
                newEmployee.setId(id);
                return empRepository.save(newEmployee);
            });
        }


    @DeleteMapping("/employee/{id}")
        void deleteEmployee(@PathVariable Long id){
            empRepository.deleteById(id);
        }

    }

    
    
