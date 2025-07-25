package com.kh.miniTodo.mapper;

import com.kh.miniTodo.vo.TodoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    // 등록
    @Insert("""
            INSERT INTO TODO
            (
                ID
                ,CONTENT
            )
            VALUES
            (
                SEQ_TODO.NEXTVAL
                ,#{content}
            )
            """)
    int insertTodo(TodoVo vo);

    // 조회
    @Select("""
            SELECT
                ID
                ,CONTENT
                ,COMPLETE
                ,CREATE_AT
            FROM TODO
            ORDER BY ID ASC
            """)
    List<TodoVo> todoList();

    // 단건 조회
    @Select("""
            SELECT
                ID
                ,CONTENT
                ,COMPLETE
                ,CREATE_AT
            FROM TODO
            WHERE ID = #{id}
            """)
    TodoVo selectOneTodo(int id);

    // 수정
    @Update("""
            UPDATE TODO
            SET
                CONTENT = #{content}
            WHERE ID = #{id}
            """)
    int updateTodo(TodoVo vo);

    // 논리 삭제
    @Update("""
            UPDATE TODO
            SET
                COMPLETE = 'Y'
            WHERE ID = #{id}
            """)
    int deleteTodo(int id);
}
