package com.invensis.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invensis.entity.ProfessionDetails;

@Repository
public interface ProfessionDetailsRepo extends JpaRepository<ProfessionDetails, Integer>{

	Optional<ProfessionDetails> findByEmpId(int id);

}
