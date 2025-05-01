package com.yep.wms.application.service.impl;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.application.dto.ProjectRequestDto;
import com.yep.wms.application.mapper.ProjectMapper;
import com.yep.wms.application.service.ProjectControllerService;
import com.yep.wms.domain.model.Project;
import com.yep.wms.domain.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectControllerServiceImpl implements ProjectControllerService {
    private ProjectRepository projectRepository;

    @Override
    public Mono<ProjectDto> createProject(ProjectRequestDto projectRequestDto) {
        Project project = buildProject(projectRequestDto);
        return projectRepository.save(project)
                .map(ProjectMapper::entityToDTO);
    }

    private Project buildProject(ProjectRequestDto projectRequestDto) {
        return Project.builder()
                .id(UUID.randomUUID())
                .name(projectRequestDto.getName())
                .ownerId(RandomUtil.getPositiveInt())
                .description(projectRequestDto.getDescription())
                .build();
    }

    @Override
    public Mono<ProjectDto> getProject(UUID id) {
        return projectRepository.findById(id)
                .map(ProjectMapper::entityToDTO);
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Flux<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .map(ProjectMapper::entityToDTO);
    }
}
