package com.example.sms.Repostitories;

import com.example.sms.Entity.StudtentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepostiory extends JpaRepository<StudtentEntity, Long> {
}
