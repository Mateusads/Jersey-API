package com.cingo.logstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Log {	
	
	@Id
	@GeneratedValue
	private int id;
	@Column(columnDefinition = "TEXT")
	private String content;
	private int occurrences;

	public Log() {
		super();
	}

	public Log(String content, int occurrences) {
		super();
		this.content = content;
		this.occurrences = occurrences;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOccurrences() {
		return this.occurrences;
	}
	public void setOccurrences(int ocorrencias) {
		this.occurrences = ocorrencias;
	}
	public void newOcurrence(int occurrences) {
		this.occurrences = this.occurrences + occurrences;
	}
}
