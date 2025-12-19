package org.fatma.teacher.service;

import org.fatma.teacher.dto.APIResponseDto;
import org.fatma.teacher.dto.TeacherDto;

public interface TeacherService
{
    APIResponseDto getTeacherById(Long id);
}
