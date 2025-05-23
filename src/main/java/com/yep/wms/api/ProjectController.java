package com.yep.wms.api;

import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.application.dto.ProjectRequestDto;
import com.yep.wms.application.service.ProjectControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectControllerService projectControllerService;

    @GetMapping("/{id}")
    private Mono<ProjectDto> getProject(@PathVariable Integer id){
        return projectControllerService.getProject(id);
    }

    @DeleteMapping("/{id}")
    private void deleteProject(@RequestParam Integer id){
        projectControllerService.deleteProject(id);
    }

    @PostMapping("")
    private Mono<ProjectDto> createProject(@RequestBody ProjectRequestDto projectRequestDto){
        return projectControllerService.createProject(projectRequestDto);
    }

    @GetMapping("")
    private Flux<ProjectDto> getAllProjects(){
        return projectControllerService.getAllProjects();
    }
}
