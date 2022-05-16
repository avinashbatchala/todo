package com.nashb.todo.todo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ToDo {

    @Id
    @Generated
    private long todoId;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "task_desc", nullable = false, length = 500)
    private String taskDesc;

    @Column(name = "is_finished")
    private boolean isFinished;
}
