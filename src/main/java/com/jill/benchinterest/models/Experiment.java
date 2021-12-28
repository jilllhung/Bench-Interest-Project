package com.jill.benchinterest.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "experiments")
public class Experiment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String expName;
	//Should default to today
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expDate;
	private Double temp;
	//Should change this to file, pointer to S3
	@NotEmpty
	private String steps;
	private String comments;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="expperformer_id")
//	private User expPerformer; 
	
	@OneToMany(mappedBy="accordingToExp", fetch = FetchType.LAZY)
	private List<Sample> madeSamples;

	@OneToMany(mappedBy="recipeExp", fetch = FetchType.LAZY)
	private List<Recipe> usedRecipes;
	
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="samples_experiments", 
//    		joinColumns = @JoinColumn(name = "experiment_id"), 
//    		inverseJoinColumns = @JoinColumn(name ="sample_id")
//    )
//    private List<Sample> usedSamples;
	
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
    
    //Empty Constructor
    public Experiment() {
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpName() {
		return expName;
	}
	public void setExpName(String expName) {
		this.expName = expName;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
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
	public List<Sample> getSamplesMadeFromExp() {
		return madeSamples;
	}
	public void setSamplesMadeFromExp(List<Sample> samplesMadeFromExp) {
		this.madeSamples = samplesMadeFromExp;
	}
	public List<Recipe> getUsedRecipes() {
		return usedRecipes;
	}
	public void setUsedRecipes(List<Recipe> usedRecipes) {
		this.usedRecipes = usedRecipes;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<Sample> getMadeSamples() {
		return madeSamples;
	}
	public void setMadeSamples(List<Sample> madeSamples) {
		this.madeSamples = madeSamples;
	}
	
    
}
