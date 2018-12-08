package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.TodoRepository;
import lv.javaguru.java2.console.domain.Todo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TodoRepositoryImpl implements TodoRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Todo todo) {
        sessionFactory.getCurrentSession().save(todo);
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        Todo todo = (Todo) sessionFactory.getCurrentSession().createCriteria(Todo.class)
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(todo);
    }

    @Override
    public boolean remove(Todo todo) {
        sessionFactory.getCurrentSession().delete(todo);
        return true;
    }

    @Override
    public List<Todo> getAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Todo.class)
                .list();
    }
}