package com.todolist.todo_list;

import com.todolist.todo_list.domain.ToDoList;
import com.todolist.todo_list.domain.ToDoListRepository;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ToDoListRepositoryTest {
    @Autowired
    ToDoListRepository toDoListRepository;
    Long sequnce = 0L;

    @Test
    public void create() {
        ToDoList list1 = ToDoList.builder()
                .content("스프링공부")
                .completed(true)
                .build();

        toDoListRepository.save(list1);
        assertThat(list1.getContent()).isEqualTo("스프링공부");
    }

    @Test
    public void read() {
        Optional<ToDoList> result = toDoListRepository.findById(1L);

        System.out.println(result);
    }

    @Test
    public void update() {
        
    }

    @Test
    public void delete() {
        toDoListRepository.deleteById(1L);
    }
}