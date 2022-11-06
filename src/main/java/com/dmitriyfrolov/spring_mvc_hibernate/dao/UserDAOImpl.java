package com.dmitriyfrolov.spring_mvc_hibernate.dao;

import com.dmitriyfrolov.spring_mvc_hibernate.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String query = "from User";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    @Override
    public void saveUser(User user) { entityManager.persist(user); }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User updatedUser = show(id);
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setAge(user.getAge());
        updatedUser.setSpecialization(user.getSpecialization());
        updatedUser.setSalary(user.getSalary());
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.contains(show(id)) ? show(id) : entityManager.merge(show(id)));
    }
}
