package com.devwdougherty.user.service.service;

import com.devwdougherty.user.service.VO.DepartmentVO;
import com.devwdougherty.user.service.VO.ResponseTemplateVO;
import com.devwdougherty.user.service.model.User;
import com.devwdougherty.user.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public User findByUserId(Long userid) {

        log.info("Inside findByUserId of UserService");

        return userRepository.findByUserId(userid);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment of UserService");

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        DepartmentVO departmentVO = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + user.getUserId(), DepartmentVO.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartmentVO(departmentVO);

        return responseTemplateVO;
    }
}

