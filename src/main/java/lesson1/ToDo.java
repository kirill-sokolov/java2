package lesson1;

import java.util.Objects;

class ToDo {

    private String description;
    private Integer id;

    public ToDo(String description, Integer id) {
        this.description = description;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(description, toDo.description) &&
                Objects.equals(id, toDo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "name='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
