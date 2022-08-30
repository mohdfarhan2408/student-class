package com.example.studentclass.Repositories;


import com.example.studentclass.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {

    @Query(value = "SELECT * FROM class WHERE status = ACTIVE ", nativeQuery = true)
    Collection<Class> findAllActiveClasses(Class activeClass);
}
