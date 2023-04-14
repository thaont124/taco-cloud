package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import tacos.model.Taco_Order;

public interface Taco_OrderRepository extends JpaRepository<Taco_Order, Integer> {
    default boolean exists(int tacoId, int orderId){
        return existsByTacoIdAndOrderId(tacoId, orderId);
    }

    boolean existsByTacoIdAndOrderId(int tacoId, int orderId);
}