package com.zepto.zepto.service;

import com.zepto.zepto.models.*;
import com.zepto.zepto.requestDTO.RequestOrderProductDTO;
import com.zepto.zepto.responsedto.ResponseBillDTO;
import com.zepto.zepto.responsedto.ResponseBillProductDTO;
import com.zepto.zepto.utils.DatabaseAPIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Autowired
    WareHouseService wareHouseService;

    public ResponseBillDTO placeOrder(List<RequestOrderProductDTO> products, UUID userId){
        AppUser user=databaseAPIUtil.getUserByUserId(userId);
        if(user==null){
            throw new RuntimeException("User does not exists");
        }
        String pincode =user.getPincode();
        WareHouse wareHouse=databaseAPIUtil.getWareHouseByPincode(pincode);
        if(wareHouse ==null){
            throw new RuntimeException("We regret to inform you warehouse is not present at your pincode");

        }
        ResponseBillDTO bill=new ResponseBillDTO();
        List<ResponseBillProductDTO> billProducts=new ArrayList<>();

        AppOrder order=new AppOrder();
        List<Product> orderProducts=new ArrayList<>();
        double totalAmount=0.0;

        for(RequestOrderProductDTO product: products){
            UUID pid=product.getPid();
            WareHouseProduct wareHouseProduct=wareHouseService.getProductByWidPid(wareHouse.getId(),pid);

            if(wareHouseProduct.getTotalQuantity()<product.getQuantity()){
                throw new RuntimeException("Product does not have enough quantity");
            }
            Product oP=wareHouseService.getProductById(pid);
            orderProducts.add(oP);

            ResponseBillProductDTO billProductDTO=new ResponseBillProductDTO();
            billProductDTO.setProductId(pid);
            billProductDTO.setQuantity(product.getQuantity());
            double priceAfterDiscount=this.getPriceAfterDiscount(oP.getProductPrice(),wareHouseProduct.getDiscount());
            billProductDTO.setAmount(product.getQuantity()*priceAfterDiscount);
            billProductDTO.setProductName(oP.getProductName());

            billProducts.add(billProductDTO);
            totalAmount+=priceAfterDiscount;
        }
        order.setCustomer(user);
        order.setPlacedTime(LocalDateTime.now());
        order.setProducts(orderProducts);
        order.setTotalamount(totalAmount);

        order=databaseAPIUtil.saveOrder(order);

        bill.setOrderId(order.getId());
        bill.setOrderPlacedTime(LocalDateTime.now());
        bill.setTotalBillPayed(totalAmount);
        bill.setProducts(billProducts);
        return bill;

    }

    private double getPriceAfterDiscount(int productPrice, int discount) {
        return 0.1;
    }
}
