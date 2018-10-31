package lesson2.domain;

import java.util.Objects;

public class Todo {

    private String description;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(description, todo.description) &&
                Objects.equals(title, todo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, title);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "name='" + description + '\'' +
                ", title=" + title +
                '}';
    }
}
