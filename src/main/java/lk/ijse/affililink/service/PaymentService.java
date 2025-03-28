package lk.ijse.affililink.service;


import lk.ijse.affililink.model.CartData;

public interface PaymentService {
    void placeOrder(CartData cartData);

    void getAllOrders();
}
