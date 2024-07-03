package com.example.todo.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "todotbl")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert // default

public class Todo extends BaseEntity {
    //

    //
    //
    @Id
    @Column(name = "todo_id")
    @SequenceGenerator(name = "todo_seq_gen", sequenceName = "todo_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq_gen")
    private Long id;

    // @Column(nullable = false)
    @ColumnDefault("0") // sql 구문에서 default 값을 설정하는 것과 같음
    // 불린 타입이기에 ColumnDefault 어노테이션으로 디폴트를 0 으로 설정 해놓음
    private Boolean completed;

    //

    // @Column(nullable = false)
    @ColumnDefault("0")
    // 불린 타입이기에 ColumnDefault 어노테이션으로 디폴트를 0 으로 설정 해놓음
    private Boolean important;

    //

    @Column(nullable = false)
    private String title;

}
// dafault 값을 삽입 : 아무 것도 입력이 되지 않으면 defalut 값으로 입력해주라는 의미

// JPA 에서는 디펄트 값으로 자동 삽입 하려면 @DynamicInsert 어노테이션이 필요함
// @DynamicInsert 에 의미 는 : 데이터가 존재하는 필드만으로 insert SQL 문 생성
