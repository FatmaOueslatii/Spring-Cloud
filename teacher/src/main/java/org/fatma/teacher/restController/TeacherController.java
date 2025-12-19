package org.fatma.teacher.restController;

import lombok.AllArgsConstructor;
import org.fatma.teacher.dto.APIResponseDto;
import org.fatma.teacher.dto.TeacherDto;
import org.fatma.teacher.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;

    @GetMapping("{id}")
//    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable  ("id") Long id )
//    {
//        return new ResponseEntity<TeacherDto>(
//                teacherService.getTeacherById(id),
//                HttpStatus.OK);
//    }

    public APIResponseDto getTeacherById(@PathVariable  ("id") Long id )
    {
        return teacherService.getTeacherById(id);
    }


}
