package tacos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tacos.model.Ingredient;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/ingredients")
    public String addIngredientForm(Model model) {
        return "addIngredient";
    }
}