package com.kh.miniTodo.vo;

import lombok.Data;

@Data
public class TodoVo {
    private int id;
    private String content;
    private String complete;
    private String createAt;
}
