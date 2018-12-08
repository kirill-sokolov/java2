package lv.javaguru.java2.console.database.orm;

import lv.javaguru.java2.console.database.UserRepository;
import lv.javaguru.java2.console.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
        return Optional.ofNullable(user);
    }

//    @Override
//    public boolean remove(User user) {
//        sessionFactory.getCurrentSession().delete(user);
//        return true;
//    }
//
//    @Override
//    public List<User> getAll() {
//        return sessionFactory.getCurrentSession()
//                .createCriteria(User.class)
//                .list();
//    }
}