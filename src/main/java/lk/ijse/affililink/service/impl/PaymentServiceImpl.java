package lk.ijse.affililink.service.impl;

import lk.ijse.affililink.dto.OrderDTO;
import lk.ijse.affililink.dto.ProductDTO;
import lk.ijse.affililink.dto.UserDTO;
import lk.ijse.affililink.entity.Order;
import lk.ijse.affililink.entity.OrderDetail;
import lk.ijse.affililink.entity.Product;
import lk.ijse.affililink.entity.User;
import lk.ijse.affililink.model.CartData;
import lk.ijse.affililink.repo.OrderDetailRepo;
import lk.ijse.affililink.repo.OrderRepo;
import lk.ijse.affililink.repo.ProductRepository;
import lk.ijse.affililink.repo.UserRepository;
import lk.ijse.affililink.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void placeOrder(CartData cartData) {
        UserDTO customerDTO = cartData.getUserDTO();
        List<ProductDTO> itemDTOS = cartData.getProductDTO();

        //update qty
        for (ProductDTO productDTO :itemDTOS) {
            Product product = productRepo.findById(productDTO
                    .getProductId()).orElseThrow(() -> new RuntimeException("Item not found"));
            product.setQty(product.getQty() - productDTO.getQty());
            productRepo.save(product);
        }

        //save order
        Order order = new Order();
        order.setUser(modelMapper.map(customerDTO, User.class));
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        orderRepo.save(order);
        orderRepo.flush();

        //save order details
        for (ProductDTO productDTO : itemDTOS) {
            Product product = modelMapper.map(productDTO, Product.class);
            OrderDetail od = new OrderDetail();
            od.setOrder(order);
            od.setProduct(product);
            orderDetailRepo.save(od);
        }
    }

    @Override
    public void getAllOrders() {
        OrderDetail od = orderDetailRepo.findById(1)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        System.out.println("=====================================");
        System.out.println(od.getProduct().getName());
    }
}
