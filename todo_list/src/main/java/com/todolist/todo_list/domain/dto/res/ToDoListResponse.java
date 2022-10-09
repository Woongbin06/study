package com.todolist.todo_list.domain.dto.res;

import com.todolist.todo_list.domain.entity.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListResponse {

    private Long id;
    private String content;
    private Boolean completed;
    private String url;

    public ToDoListResponse(ToDoList toDoList){
        this.id = toDoList.getId();
        this.content = toDoList.getContent();
        this.completed = toDoList.getCompleted();

        this.url = "http://localhost:8080/" + this.id;
    }

}
