package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, UUID> {

}
