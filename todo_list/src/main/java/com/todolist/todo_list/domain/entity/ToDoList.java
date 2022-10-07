package com.todolist.todo_list.domain.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotNull
    private String content;

    @Column(nullable = false)
    private Boolean completed;


    @Builder
    public ToDoList(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }
}
