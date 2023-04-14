package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.data.Taco_IngredientsRepository;
import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.model.Taco_Ingredients;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @Autowired
    private IngredientRepository ingredientRepo;
    @Autowired
    private TacoRepository tacoRepo;
    @Autowired
    private Taco_IngredientsRepository taco_ingredientsRepo;
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));

        }
    }
    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> ingrList = new ArrayList<>();
        for (Ingredient ingredient: ingredients) {
            if (ingredient.getType().equals(type)) ingrList.add(ingredient);
        }
        return ingrList;

    }
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@ModelAttribute("taco") Taco taco,
                                @RequestParam("ingredients") List<String> ingredientIds) {
        Taco newTaco = tacoRepo.save(taco);
        for (String ingrId : ingredientIds){
            if (!taco_ingredientsRepo.exists(newTaco.getId(),ingrId)) {
                Taco_Ingredients ta_in = new Taco_Ingredients();
                ta_in.setTacoId(newTaco.getId());
                ta_in.setIngredientId(ingrId);
                taco_ingredientsRepo.save(ta_in);
            }
        }

        return "redirect:/orders/current";
    }


}
