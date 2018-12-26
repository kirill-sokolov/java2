package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.TodoListRepository;
import lv.javaguru.java2.console.domain.TodoList;
import lv.javaguru.java2.console.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class TodoListRepositoryImpl extends ORMRepository implements TodoListRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(TodoList todoList) {
        session().save(todoList);
    }

    @Override
    public Optional<TodoList> findByUserAndTitle(User user, String title) {
        TodoList todoList = (TodoList) session().createCriteria(TodoList.class)
                .add(Restrictions.eq("user", user))
                .add(Restrictions.eq("title", title))
                .uniqueResult();
        return Optional.ofNullable(todoList);
    }

//    @Override
//    public boolean remove(User user) {
//        session().delete(user);
//        return true;
//    }
//
//    @Override
//    public List<User> getAll() {
//        return session()
//                .createCriteria(User.class)
//                .list();
//    }
}