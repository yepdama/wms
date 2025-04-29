package com.yep.wms.domain.model;

import com.yep.wms.application.enums.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("task")
@Data
public class Task {
    //Task: id, title, description, status (enum),
    // projectId (FK), assignedTo (FK to User), dueDate, createdAt
    @Id
    private UUID id;
    private String title;
    private String description;
    //TODO: use converter to convert Status enum to string
    private Status status;

    @Column("project_id")
    private UUID projectId;

    @Column("assigned_to")
    private UUID assignedTo;

    @Column("due_date")
    private Date duedate;

    @Column("created_at")
    private Long createdAt;
}
