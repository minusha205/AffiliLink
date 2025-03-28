package lk.ijse.affililink.controller;

import jakarta.validation.Valid;
import lk.ijse.affililink.dto.ProductDTO;
import lk.ijse.affililink.dto.ResponseDTO;
import lk.ijse.affililink.service.ProductService;
import lk.ijse.affililink.service.impl.ProductServiceImpl;
import lk.ijse.affililink.util.VarList;
import org.springframework.http.HttpStatus;
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
        System.out.println(productDTO.getImage());
        productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Product Saved Successfully", null));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Product Deleted Successfully", null));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDTO> updateProduct(@PathVariable int id, @RequestBody @Valid ProductDTO productDTO) {
        System.out.println(productDTO.getImage());
        productServiceImpl.update(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Product Updated Successfully", null));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Success", productService.getAllProduct()));
    }
}