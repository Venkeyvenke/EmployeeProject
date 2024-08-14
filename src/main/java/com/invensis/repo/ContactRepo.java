package com.invensis.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invensis.entity.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

	Optional<Contact> findByEmpId(int id);

}
