//package tacos.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import lombok.extern.slf4j.Slf4j;
//import tacos.model.Order;
//import tacos.data.OrderRepository;
//
//@Slf4j
//@Controller
//@RequestMapping("/orders")
//public class OrderController {
//    @Autowired
//    private OrderRepository orderRepo;
//
//    @GetMapping("/current")
//    public String orderForm(Model model) {
//        model.addAttribute("order", new Order());
//        return "orderForm";
//    }
//    @PostMapping
//    public String processOrder(Order order) {
//        orderRepo.save(order);
//        return "redirect:/";
//    }
//
//
//}
