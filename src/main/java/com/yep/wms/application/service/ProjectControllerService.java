package com.yep.wms.application.service;

import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.application.dto.ProjectRequestDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProjectControllerService {
    Mono<ProjectDto> createProject(ProjectRequestDto projectRequestDto);

    Mono<ProjectDto> getProject(Integer id);

    void deleteProject(Integer id);

    Flux<ProjectDto> getAllProjects();
}
