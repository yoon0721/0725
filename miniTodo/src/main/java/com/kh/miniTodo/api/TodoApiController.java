package com.kh.miniTodo.api;

import com.kh.miniTodo.service.TodoService;
import com.kh.miniTodo.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoApiController {
    private final TodoService service;

    // 등록
    @PostMapping("insert")
    public ResponseEntity<Integer> insertTodo(@RequestBody TodoVo vo){
        int result = service.insertTodo(vo);
        return ResponseEntity
                .ok(result);
    }
    // 조회
    @GetMapping
    public ResponseEntity<List<TodoVo>> todoList(){
        List<TodoVo> voList = service.todoList();
        return ResponseEntity
                .ok(voList);
    }
    // 단건 조회
    @GetMapping("{id}")
    public ResponseEntity<TodoVo> selectOneTodo(@PathVariable int id){
        TodoVo vo = service.selectOneTodo(id);
        return ResponseEntity
                .ok(vo);
    }
    // 수정
    @PutMapping("{id}")
    public ResponseEntity<Integer> updateTodo(@PathVariable int id, @RequestBody TodoVo vo){
        vo.setId(id);
        int result = service.updateTodo(vo);
        return ResponseEntity
                .ok(result);
    }
    // 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteTodo(@PathVariable int id){
        int result = service.deleteTodo(id);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
