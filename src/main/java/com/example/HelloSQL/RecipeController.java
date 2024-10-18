package com.example.HelloSQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/rate/{id}")
    public void rateRecipe(@PathVariable Long id, @RequestParam double rating) {
        recipeService.rateRecipe(id, rating);
    }
    
    @GetMapping("/view")
public String viewRecipes(Model model) {
    List<RecipeModel> recipes = recipeService.getAllRecipes();
    model.addAttribute("recipes", recipes);
    return "viewRecipes";
}


    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }
}
