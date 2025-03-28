package lk.ijse.affililink.dto;

public class ProductDTO {

    private int productId;
    private int qty;
    private String name;
    private String description;
    private double price;
    private String affiliateLink;
    private String image;
    // Default constructor
    public ProductDTO() {
    }

    // Constructor with fields
    public ProductDTO(int productId, String name, String description, double price, String affiliateLink,String image,int qty) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", affiliateLink='" + affiliateLink + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
