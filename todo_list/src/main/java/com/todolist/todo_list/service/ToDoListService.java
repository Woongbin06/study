package com.todolist.todo_list.service;

import com.todolist.todo_list.domain.ToDoListRepository;
import com.todolist.todo_list.domain.dto.req.ToDoListRequest;
import com.todolist.todo_list.domain.entity.ToDoList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoList create(ToDoListRequest request) {
        ToDoList toDoList = ToDoList.builder()
                .content(request.getContent())
                .completed(request.getCompleted())
                .build();

        return this.toDoListRepository.save(toDoList);
    }

    public ToDoList findById(Long id) {
        return this.toDoListRepository.findById(id)
                .orElseThrow(() -> new Exception());
    }
}
