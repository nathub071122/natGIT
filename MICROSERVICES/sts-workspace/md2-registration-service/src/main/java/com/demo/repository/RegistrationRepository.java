package com.demo.repository;
import com.demo.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String> {
    Registration findByEmail(String email);
    Registration findByEmailAndPassword(String email, String password);
}
