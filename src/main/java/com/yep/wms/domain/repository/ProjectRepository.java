package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProjectRepository extends ReactiveCrudRepository<Project, Integer> {
}
