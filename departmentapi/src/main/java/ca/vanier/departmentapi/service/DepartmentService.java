package ca.vanier.departmentapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.departmentapi.entity.Department;


public interface DepartmentService {

    // save operation
    Department saveDepartment(Department department);
    
    // read operation
    List<Department> fetchDepartmentList();

    //update operation
    Department updateDepartment (Department department,  Long departmentId);

    // delete operation
    void deleteDepartmentById (Long departmentId);

    //find
    Optional<Department> findByDepartmentId (Long id);
}

    

