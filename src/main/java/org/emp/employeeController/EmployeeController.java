package org.emp.employeeController;


import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.emp.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService service;
    @PostMapping("add-employee")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
    @GetMapping("get-all")
    public List<EmployeeEntity> getAlll(){
        return service.getAll();
    }
}
