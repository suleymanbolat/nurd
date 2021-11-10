package com.nurd.assigment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "email" )
    private User creator;
    private String title;
    private String description;
    private long dueDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id" )
    private Group group;
    private Status status;

}
