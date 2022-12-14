package ca.vanier.departmentapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.vanier.departmentapi.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Long>{  // <entity name, primary key variable type>
    
}

