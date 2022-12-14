package ca.vanier.departmentapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.departmentapi.entity.Department;
import ca.vanier.departmentapi.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    

    //save operation
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save (department);
    }

    
    // read operation
    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>)departmentRepository.findAll();
    }


    //update operation
    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        
    
        Department deptDB = departmentRepository.findById(departmentId).get();

        if(department == null){
            System.out.println("Department not found");
            return null;
        }

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
            }
        
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
             }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
            }

        return departmentRepository.save(deptDB);
    }


    // delete operation
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId); 
    }

    
    //find operation
    @Override
    public Optional<Department> findByDepartmentId(Long id) {
        return departmentRepository.findById(id); 
    }
    
}
