package com.devwdougherty.user.service.VO;

import com.devwdougherty.user.service.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private DepartmentVO departmentVO;
}
