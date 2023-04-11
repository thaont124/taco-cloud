package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tacos.Order;
//import tacos.User;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);
    //List<Order> readOrdersByUserOrderByPlacedAtDesc(User user);
    List<Order> findByPlacedAtBetween(Date startDate, Date endDate);

}
