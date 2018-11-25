package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.TodoRepository;
import lv.javaguru.java2.domain.Todo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class TodoRepositoryImpl
        extends JDBCRepository
        implements TodoRepository {

    @Override
    public void save(Todo todo) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into todos(id, title, description) values(default, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                todo.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute TodoDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sql = "select * from todos where title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            Todo todo = null;
            if (resultSet.next()) {
                todo = new Todo();
                todo.setId(resultSet.getLong("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
            }
            return Optional.ofNullable(todo);
        } catch (Throwable e) {
            System.out.println("Exception while execute TodoDAOImpl.getByTitle()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean remove(Todo todo) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from todos where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, todo.getId());
            int numOfRowsDeleted = preparedStatement.executeUpdate();
            return numOfRowsDeleted == 1;
        } catch (Throwable e) {
            System.out.println("Exception while execute TODODAOImpl.delete()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from todos";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getLong("id"));
                todo.setTitle(resultSet.getString("title"));
                todo.setDescription(resultSet.getString("description"));
                todos.add(todo);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list TodoDAOImpl.getAll()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return todos;
    }

}