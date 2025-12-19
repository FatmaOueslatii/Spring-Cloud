package org.fatma.department.repos;

import org.fatma.department.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Long>
{
    Department findByDepCode(String code);
}
