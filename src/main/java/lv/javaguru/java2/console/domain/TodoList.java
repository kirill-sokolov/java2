package lv.javaguru.java2.console.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todo_lists")
public class TodoList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name = "loginId", nullable = false)
//    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    public TodoList() {
    }

    public TodoList(Long id, User user, String title) {
        this.id = id;
        this.user = user;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TodoList todoList = (TodoList) o;
//
//        if (id != null ? !id.equals(user.id) : user.id != null) return false;
//        if (user != null ? !user.equals(user.user) : user.user != null) return false;
//        return title != null ? title.equals(user.title) : user.title == null;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(title, user);
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
