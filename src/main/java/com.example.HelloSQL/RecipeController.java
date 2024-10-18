package com.example.HelloSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // This controller handles both rendering HTML views and the REST API
@RequestMapping("/user/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Display form to add a new recipe and display success message if available
    @GetMapping("/add")
    public String showAddRecipeForm(@RequestParam(required = false) String success, Model model) {
        model.addAttribute("successMessage", success);
        return "addRecipe";  // Return the form page for adding recipes
    }

    // Add a recipe to the database
    @PostMapping("/add")
    public String addRecipe(@ModelAttribute RecipeModel newRecipe) {
        recipeService.addRecipe(newRecipe);
        // Redirect back to the add page with a success message
        return "redirect:/user/recipe/add?success=Recipe added successfully!";
    }

    // Display all recipes in the view page
    @GetMapping("/view")
    public String viewRecipes(Model model) {
        List<RecipeModel> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    // Rate a recipe
    @PostMapping("/rate/{id}")
    public String rateRecipe(@PathVariable Long id, @RequestParam double rating) {
        recipeService.rateRecipe(id, rating);
        return "redirect:/user/recipe/view";  // Redirect to the display page after rating
    }

    // Delete a recipe
    @PostMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return "redirect:/user/recipe/view";  // Redirect to the display page after deletion
    }
}
