package lk.ijse.affililink.dto;

import java.util.Date;

public class OrderDTO {

    private int orderId;
    private int userId;
    private int productId;
    private String affiliateLink;
    private Date orderDate;
    private double totalAmount;

    // Default constructor
    public OrderDTO() {
    }

    // Constructor with fields
    public OrderDTO(int orderId, int userId, int productId, String affiliateLink, Date orderDate, double totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.affiliateLink = affiliateLink;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(String affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", affiliateLink='" + affiliateLink + '\'' +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
