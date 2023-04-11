package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tacos.model.Ingredient;
import tacos.data.IngredientRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;


    @GetMapping
    public String listIngredients(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "ingredients";
    }

    // Hiển thị form để thêm mới một thành phần Ingredient
    @GetMapping("/add")
    public String addIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "addIngredient";
    }

    // Xử lý thêm mới một thành phần Ingredient
    @PostMapping("/add")
    public String addIngredient(@ModelAttribute("ingredient") @Valid Ingredient ingredient,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "addIngredient";
        }
        ingredientRepository.save(ingredient);
        return "redirect:/";
    }

    // Hiển thị form để sửa thông tin một thành phần Ingredient
    @GetMapping("/edit/{id}")
    public String editIngredientForm(@PathVariable String id, Model model) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            model.addAttribute("ingredient", ingredient.get());
            return "edit-ingredient";
        } else {
            return "redirect:/";
        }
    }

    // Xử lý sửa thông tin một thành phần Ingredient
    @PostMapping("/edit/{id}")
    public String editIngredient(@PathVariable String id,
                                 @ModelAttribute("ingredient") @Valid Ingredient ingredient,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "edit-ingredient";
        }
        ingredient.setId(id);
        ingredientRepository.save(ingredient);
        return "redirect:/";
    }
}

