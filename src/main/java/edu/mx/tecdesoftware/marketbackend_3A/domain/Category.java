package edu.mx.tecdesoftware.marketbackend_3A.domain;

public class Category {

    private int CategoryId;
    private String category;
    private boolean active;

    //Desacoplar el proyecto - empezar a hacer el mapper
    //Getters and Setters

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
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
