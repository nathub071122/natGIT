package com.demo.repository;
import com.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
//    SELECT, SEARCH, INSERT, UPDATE, DELETE OPERATIONS
}
