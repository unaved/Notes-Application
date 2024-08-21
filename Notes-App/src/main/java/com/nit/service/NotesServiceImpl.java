package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Notes;
import com.nit.entity.User;
import com.nit.repository.INotesRepository;

@Service
public class NotesServiceImpl implements INotesService{

	@Autowired
	private INotesRepository notesRepository;
	
	
	@Override
	public Notes saveNotes(Notes notes) {
		
		return this.notesRepository.save(notes);
	}

	@Override
	public Optional<Notes> getNotesByUserId(Integer noteId) {
		
		return this.notesRepository.findById(noteId);
	
	} 

	@Override
	public List<Notes> getNotesByUser(User user) {
		List<Notes> userNotes = this.notesRepository.findByUser(user);
		return userNotes;
	}

	@Override
	public Notes updateNotes(Notes notes) {
		System.out.println("Ha ha ha :"+notes.getNotesId());;
		return this.notesRepository.save(notes);
	}

	@Override
	public boolean deleteNotes(Integer noteId) {
		Optional<Notes> notes = this.notesRepository.findById(noteId);
		if(notes.isPresent()) {
			this.notesRepository.deleteById(noteId);
			return true;
		}
		return false;
//		Notes notes = this.notesRepository.findById(noteId).get();
//		if(notes!=null) {
//			notesRepository.delete(notes);
//			return true;
//		}
//		return false;
	}

	@Override
	public Notes noteByUserId(Integer noteId) {
		
		return this.notesRepository.findById(noteId).get();
	}

	
}
