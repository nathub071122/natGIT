package com.demo.repository;
import com.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
//    SELECT, SEARCH, INSERT, UPDATE, DELETE OPERATIONS
//    HIDES THE IMPLEMENTATION OF HOW THE JAVA ENTITES ARE PERSISTED TO THE DATABASE
}
