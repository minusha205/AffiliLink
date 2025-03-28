package lk.ijse.affililink.model;


import lk.ijse.affililink.dto.ProductDTO;
import lk.ijse.affililink.dto.UserDTO;

import java.util.List;

public class CartData {
    private UserDTO userDTO;
    private List<ProductDTO> productDTO;

    public CartData() {
    }

    public CartData(UserDTO userDTO, List<ProductDTO> ProductDTO) {
        this.userDTO = userDTO;
        this.productDTO = ProductDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<ProductDTO> getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(List<ProductDTO> productDTO) {
        this.productDTO = productDTO;
    }
}
