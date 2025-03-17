package lk.ijse.affililink.controller;

import jakarta.validation.Valid;
import lk.ijse.affililink.dto.ProductDTO;
import lk.ijse.affililink.dto.ResponseDTO;
import lk.ijse.affililink.service.ProductService;
import lk.ijse.affililink.service.impl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
private final ProductService productService;
private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductService productService, ProductServiceImpl productServiceImpl) {
        this.productService = productService;
        this.productServiceImpl = productServiceImpl;
    }
@PostMapping(value = "/save")
    public ResponseEntity<ResponseDTO> saveProduct(@RequestBody @Valid ProductDTO productDTO) {

    }
}
