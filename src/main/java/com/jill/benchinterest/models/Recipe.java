package com.jill.benchinterest.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double recipeSampleAmount;
	private String recipeSampleUnit;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipeexp_id")
	private Experiment recipeExp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipesample_id")
	private Sample recipeSample;
    
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //runs the method(get dates) right before the object is created
    @PrePersist 
    protected void onCreate(){
        this.createdAt = new Date();
    }
	//runs a method when the object is modified
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Recipe() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getRecipeSampleAmount() {
		return recipeSampleAmount;
	}
	public void setRecipeSampleAmount(Double recipeSampleAmount) {
		this.recipeSampleAmount = recipeSampleAmount;
	}
	public String getRecipeSampleUnit() {
		return recipeSampleUnit;
	}
	public void setRecipeSampleUnit(String recipeSampleUnit) {
		this.recipeSampleUnit = recipeSampleUnit;
	}
	public Experiment getRecipeExp() {
		return recipeExp;
	}
	public void setRecipeExp(Experiment recipeExp) {
		this.recipeExp = recipeExp;
	}
	public Sample getRecipeSample() {
		return recipeSample;
	}
	public void setRecipeSample(Sample recipeSample) {
		this.recipeSample = recipeSample;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
}
