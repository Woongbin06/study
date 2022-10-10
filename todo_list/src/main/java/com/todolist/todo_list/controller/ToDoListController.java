package com.todolist.todo_list.controller;

import com.todolist.todo_list.domain.dto.req.ToDoListRequest;
import com.todolist.todo_list.domain.dto.res.ToDoListResponse;
import com.todolist.todo_list.domain.entity.ToDoList;
import com.todolist.todo_list.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin // 모든 도메인 모든 요청방식을 허용.
@RestController
@RequestMapping("/")
public class ToDoListController {
    private final ToDoListService service;

    public ToDoListController(ToDoListService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ToDoListResponse> create(@RequestBody ToDoListRequest request) {
        System.out.println("Create");

        if (ObjectUtils.isEmpty(request.getContent())) {
            return ResponseEntity.badRequest().build(); // ResponseEntity는 사용자의 HttpRequest대한 응답 데이터를 포함함.
        }
        if (ObjectUtils.isEmpty(request.getCompleted())) { // completed가 비어있다면 false넣기.
            request.setCompleted(false);
        }

        ToDoList result = this.service.create(request);
        return ResponseEntity.ok(new ToDoListResponse(result));
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ToDoListResponse> readById(@PathVariable Long id) {
        System.out.println("Read bt id");
        ToDoList result = this.service.findById(id);
        return ResponseEntity.ok(new ToDoListResponse(result));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ToDoListResponse>> readAll() {
        System.out.println("Read all");

        List<ToDoList> find = service.findAll();
        List<ToDoListResponse> result = find.stream().map(ToDoListResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ToDoList> update() {
        System.out.println("Update");
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ToDoList> deleteById() {
        System.out.println("Delete by id");
        return null;
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<List<ToDoList>> deleteAll() {
        System.out.println("Delete all");
        return null;
    }
}
