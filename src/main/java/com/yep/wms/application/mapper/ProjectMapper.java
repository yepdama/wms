package com.yep.wms.application.mapper;

import com.yep.wms.application.dto.ProjectDto;
import com.yep.wms.domain.model.Project;

public class ProjectMapper {
    public static Project dtoToEntity(ProjectDto projectDto) {
        return Project.builder()
                .id(projectDto.getId())
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .build();
    }

    public static ProjectDto entityToDTO(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }
}
