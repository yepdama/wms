package com.yep.wms.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("project")
@Data
public class Project {
    @Id
    private UUID id;
    private String name;
    private String description;

    @Column("owner_id")
    private Integer ownerId;

    @Column("created_at")
    private Long createdAt;
}
