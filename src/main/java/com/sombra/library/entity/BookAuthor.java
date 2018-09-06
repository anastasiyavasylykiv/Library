package com.sombra.library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Anastasiya Vasylykiv
 */
@Entity
@Table(name = "author_book")
@Getter
@Setter
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
