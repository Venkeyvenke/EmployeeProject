package com.invensis.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invensis.entity.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education, Integer>{

	List<Optional<Education>> findByEmpId(int id);

}
