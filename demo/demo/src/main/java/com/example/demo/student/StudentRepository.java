package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT u FROM Student u WHERE u.name LIKE :name")
    List<Student> findUsersWithName(@Param("name") String name);

    @Query(value = "SELECT * FROM Student WHERE u.name LIKE :name", nativeQuery = true)
    List<Student> findUsersWithNameNative(@Param("name") String name);


    List<Student> findAllByName(String name);
}
