package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Notes;
import com.nit.entity.User;

public interface INotesService {
	
	Notes saveNotes(Notes notes);
	
	Notes noteByUserId(Integer noteId);
	
	Optional<Notes> getNotesByUserId(Integer noteId);
	
	List<Notes> getNotesByUser(User user);
	
	Notes updateNotes(Notes notes);
	
	boolean deleteNotes(Integer noteId);

}
