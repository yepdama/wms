package com.yep.wms.application.service.impl;

import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.application.dto.ProjectRequestDto;
import com.yep.wms.application.service.ProjectControllerService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProjectControllerServiceImpl implements ProjectControllerService {
    private ArrayList<ProjectDto> inMemory = new ArrayList<>();

    @Override
    public Mono<ProjectDto> createProject(ProjectRequestDto projectRequestDto) {
        ProjectDto projectDto = buildProjectDto(projectRequestDto);
        inMemory.add(projectDto);
        return Mono.just(projectDto);
    }

    private ProjectDto buildProjectDto(ProjectRequestDto projectRequestDto) {
        return ProjectDto.builder()
                .id(UUID.randomUUID())
                .name(projectRequestDto.getName())
                .description(projectRequestDto.getDescription())
                .build();
    }

    @Override
    public Mono<ProjectDto> getProject(UUID id) {
        return Mono.justOrEmpty(inMemory.stream()
                .filter(projectDto -> projectDto.getId().equals(id))
                .findFirst());
    }

    @Override
    public void deleteProject(UUID id) {
        inMemory.removeIf(projectDto -> projectDto.getId().equals(id));
    }

    @Override
    public Flux<ProjectDto> getAllProjects() {
        return Flux.fromIterable(inMemory);
    }
}
