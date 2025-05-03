package com.yep.wms.domain.repository;

import com.yep.wms.domain.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {

}
