package com.alura.literatura.models;

import com.alura.literatura.DTO.AuthorDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private  String name;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<Book> books;


    public Author(){}
    public Author(String name,Integer birthYear,Integer deathYear) {
        this.name = name;
        this.birthYear= birthYear;
        this.deathYear = deathYear;
    }
    public Author(AuthorDto authorDto){
        this.name=authorDto.name();
        this.birthYear=authorDto.birthYear();
        this.deathYear=authorDto.deathYear();
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "---- Author ----\n"+
                "name:"+name + '\n' +
                "birth_year:"+birthYear +'\n'+
                "death_year:"+deathYear+'\n' +
                "Libros:"+this.getBooks().stream()
                .map(Book::getTitle)
                .toList()+'\n';
    }
}