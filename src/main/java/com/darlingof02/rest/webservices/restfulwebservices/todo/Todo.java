package com.darlingof02.rest.webservices.restfulwebservices.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;


    private String username;


    private String description;


    private Date date;


    private boolean isDone;

    protected Todo() {

    }

    public Todo(long id, String username, String description, Date date, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.date = date;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
