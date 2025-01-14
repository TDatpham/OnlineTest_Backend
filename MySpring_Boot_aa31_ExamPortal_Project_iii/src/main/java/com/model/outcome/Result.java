package com.model.outcome;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Result {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int resultid;
	private int uid;
	private int quizid;
	private int numofquestions;
	private int correctanswers;
	private int marksgot;
	private int attempted;
	private String date;
	
	@Transient
	private String title;
	@Transient
	private String imagefile;
	
	@OneToMany(mappedBy ="result",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Userqna> userqnas;

	public int getUid() {
		// TODO Auto-generated method stub
		return uid;
	}

	public int getQuizid() {
		// TODO Auto-generated method stub
		return quizid;
	}

	public int getNumofquestions() {
		// TODO Auto-generated method stub
		return numofquestions;
	}

	public List<Userqna> getUserqnas() {
		// TODO Auto-generated method stub
		return userqnas;
	}

	public void setCorrectanswers(int correctanswers2) {
		// TODO Auto-generated method stub
		this.correctanswers=correctanswers2;
	}

	public void setMarksgot(int marksgot2) {
		// TODO Auto-generated method stub
		this.marksgot=marksgot2;
	}

	public void setAttempted(int attempted2) {
		// TODO Auto-generated method stub
		this.attempted=attempted2;
	}

	public void setDate(String format) {
		// TODO Auto-generated method stub
		this.date=format;
	}

	public int getCorrectanswers() {
		// TODO Auto-generated method stub
		return correctanswers;
	}

	public int getMarksgot() {
		// TODO Auto-generated method stub
		return marksgot;
	}

	public String getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		this.title=title2;
	}

	public void setImagefile(String imagefile2) {
		// TODO Auto-generated method stub
		this.imagefile=imagefile2;
	}



}
