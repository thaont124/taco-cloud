package tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tacos.model.Ingredient;
import tacos.data.IngredientRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ApiV1")
public class IngredientApiControllers {

    @Autowired
    private IngredientRepository ingredientRepository;

    

    @PostMapping("/Ingredient")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
      
        return ingredient;
    }

}

