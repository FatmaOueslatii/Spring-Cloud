package org.fatma.teacher.service;


import org.fatma.teacher.dto.DepartmentDto;
import org.springframework.stereotype.Component;

@Component
public class DeptFallback implements APIClient {
    @Override
    public DepartmentDto getDepByCode(String code) {
        return null;
    }
}
