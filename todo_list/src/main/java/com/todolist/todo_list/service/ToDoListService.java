package com.todolist.todo_list.service;

import com.todolist.todo_list.domain.ToDoListRepository;
import com.todolist.todo_list.domain.dto.req.ToDoListRequest;
import com.todolist.todo_list.domain.entity.ToDoList;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // 여러개이기 때문에 List로 묶어줌.
    public List<ToDoList> findAll() {
        return this.toDoListRepository.findAll();
    }

    public ToDoList update(Long id, ToDoListRequest request) {
        ToDoList toDoList = this.findById(id);

        toDoList = ToDoList.builder()
                .content(request.getContent())
                .completed(request.getCompleted())
                .build();

        return this.toDoListRepository.save(toDoList);
    }

    public void delete(Long id) {
        this.toDoListRepository.deleteById(id);
    }

    public void deleteAll() {
        this.toDoListRepository.deleteAll();
    }
}
