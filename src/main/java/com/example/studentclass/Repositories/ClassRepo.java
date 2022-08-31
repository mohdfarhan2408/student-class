package com.example.studentclass.Repositories;


import com.example.studentclass.Models.Class;
import com.example.studentclass.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {

    @Query(value = "SELECT c FROM Class c WHERE c.status='ACTIVE' ")
    List<Class> findAllActiveClasses();

}
