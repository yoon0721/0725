package com.kh.miniTodo.service;

import com.kh.miniTodo.mapper.TodoMapper;
import com.kh.miniTodo.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoMapper mapper;


    public int insertTodo(TodoVo vo) {
        return mapper.insertTodo(vo);
    }

    public List<TodoVo> todoList() {
        return mapper.todoList();
    }

    public TodoVo selectOneTodo(int id) {
        return mapper.selectOneTodo(id);
    }

    public int updateTodo(TodoVo vo) {
        return mapper.updateTodo(vo);
    }

    public int deleteTodo(int id) {
        return mapper.deleteTodo(id);
    }
}
