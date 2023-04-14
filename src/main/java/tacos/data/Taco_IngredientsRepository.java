package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Taco_Ingredients;

@Repository
public interface Taco_IngredientsRepository extends JpaRepository<Taco_Ingredients, Integer> {

    default boolean exists(int tacoId, String ingredientId){
        return existsByTacoIdAndIngredientId(tacoId, ingredientId);
    }

    boolean existsByTacoIdAndIngredientId(int tacoId, String ingredientId);
}
