package org.fatma.teacher.service;

import lombok.AllArgsConstructor;
import org.fatma.teacher.dto.APIResponseDto;
import org.fatma.teacher.dto.DepartmentDto;
import org.fatma.teacher.dto.TeacherDto;
import org.fatma.teacher.entities.Teacher;
import org.fatma.teacher.repos.TeacherRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService
{

    private TeacherRepository teacherRepository;
//  private WebClient webClient;
    private APIClient apiClient;

    @Override
    public APIResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();

        //La méthode de communication entre 2 microservices avec la méthode Web Client : webFlux
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" +
//                        teacher.getDepCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        //La méthode de communication entre 2 microservices avec la méthode OpenFeign
        DepartmentDto departmentDto = apiClient.getDepByCode(teacher.getDepCode());
        String dname;
        if(departmentDto == null)
            dname = "Department Not Found";
            else
            dname = departmentDto.getDepName();

        TeacherDto teacherDto = new TeacherDto(teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getDepCode(),
                dname);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setTeacherDto(teacherDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
