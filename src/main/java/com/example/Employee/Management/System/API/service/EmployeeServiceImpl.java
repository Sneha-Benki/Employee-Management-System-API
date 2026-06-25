package com.example.Employee.Management.System.API.service;

import com.example.Employee.Management.System.API.dto.EmployeeRequestDTO;
import com.example.Employee.Management.System.API.dto.EmployeeResponseDTO;
import com.example.Employee.Management.System.API.entity.Employee;
import com.example.Employee.Management.System.API.exception.EmployeeNotFoundException;
import com.example.Employee.Management.System.API.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee employee = new Employee();
        employee.setName(requestDTO.getName());
        employee.setEmail(requestDTO.getEmail());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setSalary(requestDTO.getSalary());

        Employee savedEmployee  = employeeRepository.save(employee);

        EmployeeResponseDTO  employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setId(savedEmployee.getId());
        employeeResponseDTO.setName(savedEmployee.getName());
        employeeResponseDTO.setEmail(savedEmployee.getEmail());
        employeeResponseDTO.setDepartment(savedEmployee.getDepartment());
        employeeResponseDTO.setSalary(savedEmployee.getSalary());

        return employeeResponseDTO;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) throws EmployeeNotFoundException {
       Optional<Employee> storeId = employeeRepository.findById(id);
       if (storeId.isEmpty()){
           throw new EmployeeNotFoundException(
                   "Employee not found with id: " + id
           );
       }
           Employee employee = storeId.get();
           EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
           employeeResponseDTO.setId(employee.getId());
           employeeResponseDTO.setName(employee.getName());
           employeeResponseDTO.setSalary(employee.getSalary());
           employeeResponseDTO.setEmail(employee.getEmail());
           employeeResponseDTO.setDepartment(employee.getDepartment());

           return employeeResponseDTO;
       }


    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> listEmp = employeeRepository.findAll();
        List<EmployeeResponseDTO> listEmpResponse  = new LinkedList<>();
        for (Employee employee :  listEmp ){
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            responseDTO.setId(employee.getId());
            responseDTO.setName(employee.getName());
            responseDTO.setEmail(employee.getEmail());
            responseDTO.setSalary(employee.getSalary());
            responseDTO.setDepartment(employee.getDepartment());
            listEmpResponse.add(responseDTO);

        }

        return listEmpResponse;

    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO) throws EmployeeNotFoundException {
        Optional<Employee> updateEmp = employeeRepository.findById(id);

        if(updateEmp.isEmpty()){
            throw new EmployeeNotFoundException(
                    "Employee not found with id: " + id
            );
        }

        Employee employee = updateEmp.get();

        employee.setName(requestDTO.getName());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setEmail(requestDTO.getEmail());
        employee.setSalary(requestDTO.getSalary());
        Employee saveEmp = employeeRepository.save(employee);

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(saveEmp.getId());
        employeeResponseDTO.setName(saveEmp.getName());
        employeeResponseDTO.setDepartment(saveEmp.getDepartment());
        employeeResponseDTO.setSalary(saveEmp.getSalary());
        employeeResponseDTO.setEmail(saveEmp.getEmail());

        return employeeResponseDTO;
    }

    @Override
    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        Optional<Employee>  delEmp = employeeRepository.findById(id);
        if (delEmp.isEmpty()){
            throw new EmployeeNotFoundException(
                    "Employee not found with id: " + id
            );
        }
        Employee employeee= delEmp.get();
        employeeRepository.delete(employeee);
    }
}
