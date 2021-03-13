package com.devwdougherty.department.service.controller;

import com.devwdougherty.department.service.model.Department;
import com.devwdougherty.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

        departmentService.saveDepartment(department);

        log.info("Inside saveDepartment method of DepartmentController");

        return ResponseEntity.ok().body(department);
    }

    @GetMapping(value = "/{departmentId}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable Long departmentId) {

        log.info("Inside findDepartmentById method of DepartmentController");

        Department department = departmentService.findByDepartmentId(departmentId);

        return ResponseEntity.ok().body(department);
    }
}
