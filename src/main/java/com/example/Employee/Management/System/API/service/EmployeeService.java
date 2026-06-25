package com.example.Employee.Management.System.API.service;

import com.example.Employee.Management.System.API.dto.EmployeeRequestDTO;
import com.example.Employee.Management.System.API.dto.EmployeeResponseDTO;
import com.example.Employee.Management.System.API.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);

    public EmployeeResponseDTO getEmployeeById(Long id) throws EmployeeNotFoundException;

    public List<EmployeeResponseDTO> getAllEmployees();

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO) throws EmployeeNotFoundException;

    public void deleteEmployee(Long id) throws EmployeeNotFoundException;
}
