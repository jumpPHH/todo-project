package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
/*
  @Entity Java Persistence API(JPA)에서 사용되는 어노테이션으로,
  클래스를 데이터베이스 테이블에 매핑할 때 사용
 */
@Entity
public class TodoEntity {
    /*
     @Id 필드를 엔티티의 기본 키로 지정합니다.
     기본 키는 엔티티를 고유하게 식별하는 데 사용됩니다.
    */
    @Id
    /*
     @GeneratedValue 기본 키 값이 자동으로 생성되도록 지정합니다.
     strategy 속성은 기본 키 생성 전략을 정의합니다.
     예를 들어 GenerationType.IDENTITY는 데이터베이스에서 자동으로 생성된 ID를 사용합니다.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     @Column 엔티티 클래스의 필드가 매핑될 테이블 열을 지정합니다.
     - name = "user_name": 데이터베이스에서 열 이름을 "user_name"으로 설정합니다.
     - length = 50: 문자열의 최대 길이를 50으로 제한합니다.
     - nullable = false: 해당 열은 NULL 값을 가질 수 없습니다.
     - unique = true: 해당 열의 값은 유일해야 합니다.
     */
    @Column(nullable = false)
    private String title;

    @Column(name = "todoOrder" , nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}
