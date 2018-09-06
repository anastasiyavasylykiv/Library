package com.sombra.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Anastasiya Vasylykiv
 */

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean published;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    private Integer rating;
}
