package com.example.HelloSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/user/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public List<RecipeModel> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/add")
    public RecipeModel addRecipe(@RequestBody RecipeModel newRecipe) {
        return recipeService.addRecipe(newRecipe);
    }

    @GetMapping("/view")
    public List<RecipeModel> viewRecipes() {
        return recipeService.getAllRecipes(); // JSON response
    }

    @GetMapping("/viewPage")
    public String viewRecipesPage(Model model) {
        List<RecipeModel> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "viewRecipes"; // Render the HTML template
    }
    @GetMapping("/recipes")
    public List<RecipeModel> getRecipes() {
        return recipeService.getAllRecipes();}

    @PostMapping("/recipes")
    public RecipeModel saveRecipe(@RequestBody RecipeModel recipe) {
        return recipeService.addRecipe(recipe);
    }
}
