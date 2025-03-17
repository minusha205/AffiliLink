package lk.ijse.affililink.service;

import lk.ijse.affililink.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void save(ProductDTO productDTO);

    void update(Integer id, ProductDTO productDTO);

    void delete(int id);

    List<ProductDTO> getAllProduct();
}
