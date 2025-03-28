package lk.ijse.affililink.entity;

import jakarta.persistence.*;


import java.util.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "affiliate_link")
    private String affiliateLink;

    @Column(name ="image" )
    private String image;

    @Column(name = "qty")
    private int qty;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    // Default constructor
    public Product() {
    }

    // Constructor with fields
    public Product(String name, String description, double price, String affiliateLink, String image, int qty) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.affiliateLink = affiliateLink;
        this.image = image;
        this.qty = qty;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(String affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", affiliateLink='" + affiliateLink + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
