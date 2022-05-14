package com.nashb.todo.todo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ToDo {

    @Id
    @Generated
    private long todo_id;

    private String task_name;
    private String task_desc;
    private boolean is_finished;
}
