package com.bridgelabz.User.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="NoteLabel")
public class NoteLabel {
	
	@Column(name="labelId")
	private int labelId;
	
	@Column(name="labelname")
	private String labelName;
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnore
	private User user;
	
	@ManyToMany(mappedBy = "allLabels")
	@JsonIgnore
	private Set<Note> allNotes = new  HashSet<>();

	public int getLabelId() {
		return labelId;
	}

	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Note> getAllNotes() {
		return allNotes;
	}

	public void setAllNotes(Set<Note> allNotes) {
		this.allNotes = allNotes;
	}
}
