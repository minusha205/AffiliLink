package lk.ijse.affililink.service.impl;

import lk.ijse.affililink.dto.ProductDTO;
import lk.ijse.affililink.entity.Product;
import lk.ijse.affililink.repo.ProductRepository;
import lk.ijse.affililink.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository ProductRepository;
    @Override
    public void save(ProductDTO productDTO) {
        if (ProductRepository.existsById(productDTO.getProductId())) {
            throw new RuntimeException("Item Already Exists!");
        }
        Product product = modelMapper.map(productDTO, Product.class);
        ProductRepository.save(product);

    }

    @Override
    public void update(Integer id, ProductDTO productDTO) {
    Product existingProduct = ProductRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

    existingProduct.setName(productDTO.getName());
    existingProduct.setDescription(productDTO.getDescription());
    existingProduct.setPrice(productDTO.getPrice());
    existingProduct.setAffiliateLink(productDTO.getAffiliateLink());

    ProductRepository.save(existingProduct);
    }

    @Override
    public void delete(int id) {
        ProductRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return modelMapper.map(ProductRepository.findAll(), new TypeToken<List<ProductDTO>>() {}.getType());
    }
}
