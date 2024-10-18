package com.example.HelloSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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

    @PutMapping("/rate/{id}")
    public void rateRecipe(@PathVariable Long id, @RequestParam double rating) {
        recipeService.rateRecipe(id, rating);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    // New endpoint to serve the view recipes page
    @GetMapping("/view")
    public String viewRecipes() {
        return "view-recipes"; // This should match the HTML filename without the extension
    }
}
