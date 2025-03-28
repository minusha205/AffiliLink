package lk.ijse.affililink.dto;

import lk.ijse.affililink.entity.Order;
import lk.ijse.affililink.entity.Product;

public class OrderDetailDTO {
    private int id;
    private Order order;
    private Product product;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setItem(Product product) {
        this.product = product;
    }
}
