package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TaskRepository extends ReactiveCrudRepository<Task, UUID> {
}
