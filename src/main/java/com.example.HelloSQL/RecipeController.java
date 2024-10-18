package com.example.HelloSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // Using @Controller to serve HTML pages with dynamic data
@RequestMapping("/user/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // This method renders the 'recipes.html' view and passes the recipes to the page
    @GetMapping("/view")
    public String viewRecipes(Model model) {
        List<RecipeModel> recipes = recipeService.getAllRecipes();  // Fetch recipes from DB
        model.addAttribute("recipes", recipes);  // Add recipe list to the model
        return "recipes";  // Return the Thymeleaf view (located in templates/recipes.html)
    }
}
