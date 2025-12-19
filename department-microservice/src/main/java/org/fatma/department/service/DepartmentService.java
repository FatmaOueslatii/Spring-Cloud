package org.fatma.department.service;

import org.fatma.department.dto.DepartmentDto;

public interface DepartmentService
{
    DepartmentDto getDepartmentByCode(String code);
}
