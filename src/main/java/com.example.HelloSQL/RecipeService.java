package com.example.HelloSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeModel> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public RecipeModel addRecipe(RecipeModel newRecipe) {
        return recipeRepository.save(newRecipe);
    }

    public void rateRecipe(Long id, double rating) {
        Optional<RecipeModel> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            RecipeModel recipe = optionalRecipe.get();
            double currentRating = recipe.getAverageRating();
            int numberOfRatings = recipe.getNumberOfRatings();
            double newAverageRating = ((currentRating * numberOfRatings) + rating) / (numberOfRatings + 1);
            recipe.setAverageRating(newAverageRating);
            recipe.setNumberOfRatings(numberOfRatings + 1);
            recipeRepository.save(recipe);
        }
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
