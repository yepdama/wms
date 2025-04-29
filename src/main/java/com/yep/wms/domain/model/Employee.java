package com.yep.wms.domain.model;
import com.yep.wms.application.enums.Designation;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;
import lombok.Data;
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
    private Long createdAt;
}
