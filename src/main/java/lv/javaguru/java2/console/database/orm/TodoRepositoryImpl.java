package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.TodoRepository;
import lv.javaguru.java2.console.domain.Todo;
import lv.javaguru.java2.console.domain.TodoList;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TodoRepositoryImpl extends ORMRepository implements TodoRepository {
    @Override
    public void save(Todo todo) {
        session().save(todo);
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        Todo todo = (Todo) session().createCriteria(Todo.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(todo);
    }

    @Override
    public boolean remove(Todo todo) {
        session().delete(todo);
        return true;
    }

    @Override
    public List<Todo> getAll() {
        return session()
                .createCriteria(Todo.class)
                .list();
    }

    @Override
    public List<Todo> findListItems(Long todoListId) {
        String query = "from Todo td where td.todoListId = :todoListId";
        return session().createQuery(query)
                .setParameter("todoListId", todoListId)
                .list();
    }

}