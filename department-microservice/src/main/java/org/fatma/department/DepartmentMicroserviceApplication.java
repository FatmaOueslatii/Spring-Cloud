package org.fatma.department;

import org.fatma.department.entities.Department;
import org.fatma.department.repos.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository)
    {
        return args -> {
            departmentRepository.save(Department.builder()
                    .depName("Info Tech")
                    .depCode("IT")
                    .build());
            departmentRepository.save(Department.builder()
                    .depName("Marketing")
                    .depCode("MK")
                    .build());
        };
    }

}
