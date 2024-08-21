package com.nit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="notes_tab")
@NoArgsConstructor
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notesId;
	
	private String notesTitle;
	
	private String notesDescription;
	
	private LocalDate notesCreatedAt;
	
	@ManyToOne
	private User user;

}
