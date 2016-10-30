package com.maklamine.coderedfoodapp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by davidcruz on 10/30/16.
 */

public class Recipes {
    public ArrayList<Recipe> getBreakfast(){
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Breakfast Biscuit", new ArrayList<String>(
                Arrays.asList("biscuit dough", "bacon", "eggs", "milk", "butter", "cheese")), 1, 60));
        recipes.add(new Recipe("Baked Brunch Omelet", new ArrayList<String>(
                Arrays.asList("ham", "eggs", "milk", "salt", "hot pepper sauce", "green onion")), 1, 60));
        recipes.add(new Recipe("Belgian Waffles", new ArrayList<String>(
                Arrays.asList("dry yeast", "milk", "egg yolks", "butter", "white sugar", "salt", "vanilla extract", "flour", "egg whites")), 1, 60));
        recipes.add(new Recipe("Berry smoothie",
                new ArrayList<String>(Arrays.asList("berries", "yogurt", "banana", "milk", "sugar")), 1, 60));
        recipes.add(new Recipe("Kiwi strawberry smoothie",
                new ArrayList<String>(Arrays.asList("bananas, strawberries", "kiwi", "yogurt", "orange juice")), 1, 60));

        return recipes;
    }

    public ArrayList<Recipe> getLunch(){
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Chicken Parmesan",
                new ArrayList<String>(Arrays.asList("chicken", "breadcrumbs", "eggs", "salt", "pasta sauce", "cheese", "pasta")), 1, 60));
        recipes.add(new Recipe("Chicken and Broccoli",
                new ArrayList<String>(Arrays.asList("chicken", "salt", "broccoli")), 1, 60));
        recipes.add(new Recipe("Thai beef",
                new ArrayList<String>(Arrays.asList("coriander seeds", "brown sugar", "soy sauce", "lime juice", "garlic", "ginger", "steak")), 1, 60));
        recipes.add(new Recipe("Potato and side onions",
                new ArrayList<String>(Arrays.asList("potatoes", "cumin", "chili powder", "salt", "tomatillo", "onion", "cilantro", "tortilla", "beans", "cheese", "oil")), 1, 60));
        recipes.add(new Recipe("Zucchini lasagna",
                new ArrayList<String>(Arrays.asList("pepper", "onion", "tomato paste", "tomato sauce", "red wine", "basil", "oregano", "egg", "ricotta cheese", "parsley", "spinach", "mushrooms", "mozzarella")), 1, 60));

        return recipes;
    }

    public ArrayList<Recipe> getDinner(){
        ArrayList<Recipe> recipes = new ArrayList<>();

        recipes.add(new Recipe("Prime rib roast",
                new ArrayList<String>(Arrays.asList("garlic", "prime rib roast", "oil", "salt", "pepper", "thyme")), 1, 60));
        recipes.add(new Recipe("Maple salmon",
                new ArrayList<String>(Arrays.asList("maple syrup", "soy sauce", "garlic", "garlic salt", "pepper", "salmon")), 1, 60));
        recipes.add(new Recipe("Chicken marsala",
                new ArrayList<String>(Arrays.asList("flour", "salt", "pepper", "oregano", "chicken", "butter", "oil", "mushrooms", "Marsala wine", "sherry")), 1, 60));
        recipes.add(new Recipe("Scallops Florentine",
                new ArrayList<String>(Arrays.asList("heavy cream", "cheese", "salt", "spinach", "mozzarella", "breaad crumbs", "seasoning")), 1, 60));
        recipes.add(new Recipe("Chicken pot pie",
                new ArrayList<String>(Arrays.asList("butter", "onion", "flour", "salt", "pepper", "chicken broth", "milk", "chicken", "vegetables")), 1, 60));

        return recipes;
    }
}
