package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Integer> {
}
