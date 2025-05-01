package com.yep.wms.domain.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;
import java.util.UUID;

@Table("employee")
@Data
public class Employee {
    @Id
    private UUID id;
    private String employeeId;
    private String name;
    private String email;

    //TODO: use converter to convert Designation enum to string
    private String designation;

    @Column("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;
}
