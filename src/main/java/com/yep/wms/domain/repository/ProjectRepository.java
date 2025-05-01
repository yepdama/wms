package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ProjectRepository extends ReactiveCrudRepository<Project, UUID> {
}
