package com.ravi.demo1;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(int id);

    public List<Student> findByLastName(String lastName);

    public int updateLastName(String lastName);
}
