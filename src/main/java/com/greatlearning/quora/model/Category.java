package com.greatlearning.quora.model;

public enum Category {
    EDUCATION("Education"), SPORTS("Sports"), TECHNOLOGY("Technology");
    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }
}