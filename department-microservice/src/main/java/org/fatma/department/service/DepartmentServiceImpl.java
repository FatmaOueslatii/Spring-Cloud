package org.fatma.department.service;

import lombok.AllArgsConstructor;
import org.fatma.department.dto.DepartmentDto;
import org.fatma.department.entities.Department;
import org.fatma.department.repos.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService
{
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department dep = departmentRepository.findByDepCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                dep.getId(),
                dep.getDepName(),
                dep.getDepCode()
        );
        return departmentDto;
    }
}
