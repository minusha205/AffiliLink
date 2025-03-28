package lk.ijse.affililink.controller;


import lk.ijse.affililink.model.CartData;
import lk.ijse.affililink.service.PaymentService;
import lk.ijse.affililink.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "getAll")
    public ResponseUtil getAllOrders(){
        paymentService.getAllOrders();
        return new ResponseUtil(200, "Orders Found", null);
    }

    @PostMapping(path = "save")
    public ResponseUtil placeOrder(@RequestBody CartData cartData){
        paymentService.placeOrder(cartData);
        return new ResponseUtil(200, "OrderPlaced Successfully" , null);
    }
}
