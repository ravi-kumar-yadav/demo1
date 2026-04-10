package com.ravi.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
        System.out.println("Saved student: " + theStudent.getId());
    }

    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName = :lastName", Student.class);

        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int updateLastName(String lastName){
        Query query = entityManager.createQuery("update Student s set s.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.executeUpdate();
    }
}
