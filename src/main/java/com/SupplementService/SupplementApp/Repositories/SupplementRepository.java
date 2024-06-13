package com.SupplementService.SupplementApp.Repositories;

import com.SupplementService.SupplementApp.Models.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SupplementRepository extends JpaRepository<Supplement,Integer> {

    @Query("SELECT s FROM Supplement s WHERE s.name LIKE :name%")
    Supplement findByName(@Param("name") String name);

    @Query("SELECT s.name FROM Supplement s WHERE s.name LIKE %:name%")
    List<String> findByNameContainingIgnoreCase(String name);
}
