package com.yep.wms.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;

@Table("project")
@Data
@Builder
public class Project {
    @Id
    private Integer id;
    private String name;
    private String description;

    @Column("owner_id")
    private Integer ownerId;

    @Column("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;
}
