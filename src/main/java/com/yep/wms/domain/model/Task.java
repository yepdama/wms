package com.yep.wms.domain.model;

import com.yep.wms.application.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.ZonedDateTime;
import java.util.Date;

@Table("task")
@Data
public class Task {
    @Id
    private Integer id;
    private String title;
    private String description;
    //TODO: use converter to convert Status enum to string
    private Status status;

    @Column("project_id")
    private Integer projectId;

    @Column("assigned_to")
    private Integer assignedTo;

    @Column("due_date")
    private Date duedate;

    @Column("created_at")
    @CreatedDate
    private ZonedDateTime createdAt;

    @Column("updated_at")
    private ZonedDateTime updatedAt;
}
