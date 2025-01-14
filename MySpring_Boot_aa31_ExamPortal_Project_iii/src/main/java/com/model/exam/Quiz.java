package com.model.exam;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonAutoDetect(fieldVisibility = Visibility.ANY) 
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quizid;
	
	private String title;
	
//  @Column(length=5000)
	private String description;
	
	private int maxmarks;
	
	private int numofquestions;
	
	private String image;
	
	private boolean active=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.REMOVE)
	@JsonIgnore
	private Set<Question> questions = new HashSet<>();
	
	@Transient
	private String imagefile;

	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return questions;
	}

	public int getNumofquestions() {
		// TODO Auto-generated method stub
		return numofquestions;
	}

	public void setTitle(String title3) {
		// TODO Auto-generated method stub
		this.title=title3;
	}

	public void setDescription(String description3) {
		// TODO Auto-generated method stub
		this.description=description3;
	}

	public void setMaxmarks(int int1) {
		// TODO Auto-generated method stub
		this.maxmarks=int1;
	}

	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		this.active=b;
	}

	public void setNumofquestions(int int1) {
		// TODO Auto-generated method stub
		this.numofquestions=int1;
	}

	public void setCategory(Category category2) {
		// TODO Auto-generated method stub
		this.category=category2;
	}

	public void setImage(String string) {
		// TODO Auto-generated method stub
		this.image=string;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public void setQuizid(int int1) {
		// TODO Auto-generated method stub
		this.quizid=int1;
	}

	public int getQuizid() {
		// TODO Auto-generated method stub
		return quizid;
	}

	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	public void setImagefile(String string) {
		// TODO Auto-generated method stub
		this.imagefile=string;
	}

	public int getMaxmarks() {
		// TODO Auto-generated method stub
		return maxmarks;
	}

	public String getImagefile() {
		// TODO Auto-generated method stub
		return imagefile;
	}
	
}
