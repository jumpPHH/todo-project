package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/* @NoArgsConstructor 파라미터가 없는 기본 생성자를 자동으로 생성해줍니다. */
@NoArgsConstructor
/* @AllArgsConstructor 파라미터가 전체 생성자를 자동으로 생성해줍니다. */
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private Long order;
    private Boolean completed;
}
