service 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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
        // Existing code...
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        // Add sample recipes to the database
        List<RecipeModel> sampleRecipes = new ArrayList<>();

        sampleRecipes.add(new RecipeModel(null, "Spaghetti Carbonara", 
            List.of("Spaghetti", "Eggs", "Pancetta", "Parmesan cheese", "Pepper"),
            "Cook the spaghetti, fry the pancetta, mix with eggs and cheese.",
            20, "Easy", List.of("Italian"), 4.5, 10));

        sampleRecipes.add(new RecipeModel(null, "Chicken Tikka Masala", 
            List.of("Chicken", "Yogurt", "Tomato", "Onion", "Spices"),
            "Marinate chicken, cook with spices and tomatoes.",
            30, "Medium", List.of("Indian"), 4.7, 8));

        sampleRecipes.add(new RecipeModel(null, "Beef Tacos", 
            List.of("Ground beef", "Taco shells", "Lettuce", "Cheese", "Salsa"),
            "Cook beef, assemble tacos with toppings.",
            15, "Easy", List.of("Mexican"), 4.3, 12));

        // Save sample recipes to the database
        recipeRepository.saveAll(sampleRecipes);
    }
}
