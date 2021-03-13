package com.devwdougherty.department.service.service;

import com.devwdougherty.department.service.model.Department;
import com.devwdougherty.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {

        log.info("Inside findById of DepartmentService");

        return departmentRepository.findByDepartmentId(departmentId);
    }
}
