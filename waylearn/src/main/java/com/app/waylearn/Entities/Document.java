package com.app.waylearn.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String mime_type;
	
	@Column
	private String name;
	
	@Column(unique = true)
	private String hash;
	
	@Column
	private String ext;
	
	
	@ManyToOne
	@JoinColumn(name= "lesson_id")
	private Lesson lesson_doc;
	
	public Lesson getLesson() {
		return lesson_doc;
	}

	public void setLesson(Lesson lesson) {
		this.lesson_doc = lesson;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Document() {
		super();
	}
	
	public Document(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public String getMimeType() {
		return mime_type;
	}

	public void setMimeType(String mimeType) {
		this.mime_type = mimeType;
	}

	public Lesson getLesson_doc() {
		return lesson_doc;
	}

	public void setLesson_doc(Lesson lesson_doc) {
		this.lesson_doc = lesson_doc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
