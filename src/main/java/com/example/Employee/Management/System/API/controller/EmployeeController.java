package com.example.Employee.Management.System.API.controller;

import com.example.Employee.Management.System.API.dto.EmployeeRequestDTO;
import com.example.Employee.Management.System.API.dto.EmployeeResponseDTO;
import com.example.Employee.Management.System.API.exception.EmployeeNotFoundException;
import com.example.Employee.Management.System.API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO employeeResponseDTO  =  employeeService.createEmployee(employeeRequestDTO);
        return employeeResponseDTO;
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO requestDTO) throws EmployeeNotFoundException {
        return employeeService.updateEmployee(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }
}
