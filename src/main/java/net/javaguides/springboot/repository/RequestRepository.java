package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // You can add custom query methods here if needed
}

