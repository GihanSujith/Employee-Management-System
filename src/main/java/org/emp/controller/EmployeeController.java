package org.emp.controller;


import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService service;
    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
    @GetMapping("get-all")
    public List<Employee> getAlll(){
        return service.getAll();
    }

    @DeleteMapping("/delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployeeById(id);
        return "Deleted";
    }

    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @GetMapping("/find-by-id/{id}")
    public Employee findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/find-by-firstName/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName){
        return service.findByFirstName(firstName);
    }
}
