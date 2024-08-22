package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoEntityTest {
    @Test
    void testGettersAndSetters() {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle("Test Todo");
        todoEntity.setOrder(1L);
        todoEntity.setCompleted(true);

        assertEquals("Test Todo", todoEntity.getTitle());
        assertEquals(1L, todoEntity.getOrder().longValue());
        assertTrue(todoEntity.getCompleted());

        System.out.println(todoEntity);
        System.out.println(todoEntity.toString());
    }

}