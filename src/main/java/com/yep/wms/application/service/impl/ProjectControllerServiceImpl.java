package com.yep.wms.application.service.impl;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.application.dto.ProjectRequestDto;
import com.yep.wms.application.mapper.ProjectMapper;
import com.yep.wms.application.service.ProjectControllerService;
import com.yep.wms.domain.model.Project;
import com.yep.wms.domain.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProjectControllerServiceImpl implements ProjectControllerService {
    private ProjectRepository projectRepository;

    @Override
    public Mono<ProjectDto> createProject(ProjectRequestDto projectRequestDto) {
        Project project = buildProject(projectRequestDto);
        return projectRepository.save(project)
                .switchIfEmpty(Mono.error(new RuntimeException()))
                .map(ProjectMapper::entityToDTO);
    }

    private Project buildProject(ProjectRequestDto projectRequestDto) {
        return Project.builder()
                .name(projectRequestDto.getName())
                .ownerId(RandomUtil.getPositiveInt())
                .description(projectRequestDto.getDescription())
                .build();
    }

    @Override
    public Mono<ProjectDto> getProject(Integer id) {
        return projectRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException()))
                .map(ProjectMapper::entityToDTO);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Flux<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .switchIfEmpty(Flux.error(new RuntimeException()))
                .map(ProjectMapper::entityToDTO);
    }
}
