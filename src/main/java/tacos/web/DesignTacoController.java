package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.model.Ingredient;
import tacos.model.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @Autowired
    private IngredientRepository ingredientRepo;
    @Autowired
    private TacoRepository tacoRepo;
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientRepo.findAll();
        model.addAttribute("ingredients", ingredients);
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Taco taco) {
        // Save the taco design...
        tacoRepo.save(taco);
        return "redirect:/orders/current";
    }


}
