package com.example.sms.Repostitories;

import com.example.sms.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link StudentEntity} objects.
 */
public interface StudentRepostiory extends JpaRepository<StudentEntity, Long> {
}
