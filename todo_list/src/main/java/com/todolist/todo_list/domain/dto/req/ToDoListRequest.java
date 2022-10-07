package com.todolist.todo_list.domain.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListRequest {
    private String content;
    private Boolean completed;
}
