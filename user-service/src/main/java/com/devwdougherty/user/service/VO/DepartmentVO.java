package com.devwdougherty.user.service.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentVO {

    private Long departmentId;

    private String name;

    private String address;

    private String departmentCode;
}
