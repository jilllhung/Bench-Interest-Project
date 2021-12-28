package com.jill.benchinterest.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "samples")
public class Sample {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String sampleName;
	private String sampleType;
	private Double sampleAmount;
	private String sampleUnit;
	
//	private User sampleMaker;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="experiment_id")
	private Experiment accordingToExp;
    
    @OneToMany(mappedBy="recipeSample", fetch = FetchType.LAZY)
	private List<Recipe> usedInRecipes;
    
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="samples_experiments", 
//    		joinColumns = @JoinColumn(name = "sample_id"), 
//    		inverseJoinColumns = @JoinColumn(name ="experiment_id")
//    )
//    private List<Experiment> usedInExps;
    
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
    
    public Sample() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public Double getSampleAmount() {
		return sampleAmount;
	}
	public void setSampleAmount(Double sampleAmount) {
		this.sampleAmount = sampleAmount;
	}
	public String getSampleUnit() {
		return sampleUnit;
	}
	public void setSampleUnit(String sampleUnit) {
		this.sampleUnit = sampleUnit;
	}
	public Experiment getAccordingToExp() {
		return accordingToExp;
	}
	public void setAccordingToExp(Experiment accordingToExp) {
		this.accordingToExp = accordingToExp;
	}
	public List<Recipe> getUsedInRecipes() {
		return usedInRecipes;
	}
	public void setUsedInRecipes(List<Recipe> usedInRecipes) {
		this.usedInRecipes = usedInRecipes;
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
