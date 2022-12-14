package ca.vanier.departmentapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.departmentapi.entity.Department;
import ca.vanier.departmentapi.service.DepartmentService;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    //no-args Constructor 
public DepartmentController(){
}

@Autowired
private DepartmentService departmentService;

List<Department> deptList = new ArrayList<Department>();

// save method
@PostMapping ("/departments")
public String saveDepartment(@Valid @RequestBody Department department){
     departmentService.saveDepartment(department);
     return "Department data was added successfully";
}

//Read method
@GetMapping ("/departments")
public List<Department> departmentList(){
    return departmentService.fetchDepartmentList();
} 

 //update method
 @PutMapping ("/departments/{id}")
 public String updateDepartment(@RequestBody Department department, @PathVariable("id") Long deptId){
     if(departmentService.findByDepartmentId(deptId).isPresent()) {
         departmentService.updateDepartment(department, deptId);
         return "Department data was updated successfully";
     }
     return "Department id "+deptId+" was not found";
 }

 //delete method
 @DeleteMapping ("/departments/{id}")
 public String deleteDepartment(@PathVariable("id") Long deptId){
     if(departmentService.findByDepartmentId(deptId).isPresent()) {
         departmentService.deleteDepartmentById(deptId);
         return "Department data was deleted successfully";
     }
     return "Department id "+deptId+" was not found";
 }  
}
