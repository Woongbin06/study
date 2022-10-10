package com.todolist.todo_list.controller;

import com.todolist.todo_list.domain.dto.res.ToDoListResponse;
import com.todolist.todo_list.domain.entity.ToDoList;
import com.todolist.todo_list.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin // 모든 도메인 모든 요청방식을 허용.
@RestController
@RequestMapping("/")
public class ToDoListController {
    private final ToDoListService service;

    public ToDoListController(ToDoListService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ToDoListResponse> create() {
        System.out.println("Create");
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<ToDoListResponse> readById() {
        System.out.println("Read bt id");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<ToDoListResponse>> readAll() {
        System.out.println("Read all");
        return null;
    }

    @PatchMapping("{id}")
    public ResponseEntity<ToDoList> update() {
        System.out.println("Update");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ToDoList> deleteById() {
        System.out.println("Delete by id");
        return null;
    }

    @DeleteMapping
    public ResponseEntity<List<ToDoList>> deleteAll() {
        System.out.println("Delete all");
        return null;
    }
}
