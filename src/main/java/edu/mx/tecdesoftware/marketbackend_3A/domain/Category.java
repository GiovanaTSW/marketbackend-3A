package edu.mx.tecdesoftware.marketbackend_3A.domain;

public class Category {

    private Integer categoryId;
    private String category;
    private boolean active;

    //Desacoplar el proyecto - empezar a hacer el mapper
    //Getters and Setters

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
