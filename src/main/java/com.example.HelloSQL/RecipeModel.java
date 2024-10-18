package com.example.HelloSQL;

import javax.persistence.*;
import java.util.List;

@Entity
public class RecipeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> ingredients;
    private String instructions;
    private int cookingTime;
    private String difficultyLevel;
    private double averageRating;
    private int numberOfRatings; // New field to keep track of the number of ratings
    @ElementCollection
    private List<String> labels;
    public RecipeModel() {
    }
    public RecipeModel(Long id, String title, List<String> ingredients, String instructions, int cookingTime, String difficultyLevel, List<String> labels, double averageRating, int numberOfRatings) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.difficultyLevel = difficultyLevel;
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
        this.labels = labels;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public List<String> getLabels() {
        return labels;
    }
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public int getCookingTime() {
        return cookingTime;
    }
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    public String getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    public int getNumberOfRatings() {
        return numberOfRatings;
    }
    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }
}
