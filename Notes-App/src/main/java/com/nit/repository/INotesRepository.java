package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Notes;
import com.nit.entity.User;

public interface INotesRepository extends JpaRepository<Notes, Integer> {
	
	List<Notes> findByUser(User user);

}

