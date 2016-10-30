package com.maklamine.codered;

import java.util.ArrayList;

/**
 * Created by davidcruz on 10/30/16.
 */

public class Recipe {

    Recipe(String title, ArrayList<String> ingredients, int score, int healthScore){
        this.title = title;
        this.ingredients = ingredients;
        this.score = score;
        this.healthScore = healthScore;
    }

    String title;
    ArrayList<String> ingredients;
    int score;
    int healthScore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(int healthScore) {
        this.healthScore = healthScore;
    }
}
