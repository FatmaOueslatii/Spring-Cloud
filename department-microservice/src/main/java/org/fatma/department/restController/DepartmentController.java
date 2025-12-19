package org.fatma.department.restController;

import lombok.AllArgsConstructor;
import org.fatma.department.config.Configuration;
import org.fatma.department.dto.DepartmentDto;
import org.fatma.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController
{
    @Value("${build.version}")
    private String buildVersion;

    private DepartmentService departmentService;

    @Autowired
    Configuration configuration;

    public DepartmentController(DepartmentService departmentService, Configuration configuration) {
        this.departmentService = departmentService;
        this.configuration = configuration;
    }

    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return   ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepByCode(@PathVariable("code") String code )
    {
        return  new ResponseEntity<DepartmentDto>(
                departmentService.getDepartmentByCode(code),
                HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(configuration.getName() + " " + configuration.getEmail());
    }
}
