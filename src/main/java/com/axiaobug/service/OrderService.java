package com.axiaobug.service;

import com.axiaobug.dao.OrderDao;
import com.axiaobug.pojo.Employees;
import com.axiaobug.pojo.SaleOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    public List<SaleOrder>  getAllOrder(){
        try{
            List<SaleOrder> orderList = orderDao.findAll();
            return orderList;
        }catch (Exception e){
            return null;
        }
    }

    public boolean addOrder(Date due_date,
                            String purchaser_name,
                            String mobile,
                            String area_code,
                            String product_name,
                            String order_num,
                            BigDecimal sale_price,
                            Date install_date,
                            String powder_color){
        SaleOrder order = new SaleOrder(due_date, purchaser_name, mobile, area_code, product_name, order_num, sale_price, install_date, powder_color);
        try{
            orderDao.save(order);
        }catch (Exception e){
            System.out.println("Add order error");
            return false;
        }
        return true;
    }

    public SaleOrder getOrderById(Integer id){
        try{
            SaleOrder order = orderDao.getOne(id);
            return order;
        }catch (Exception e){
            return null;
        }
    }
    public boolean updateOrder(Integer id,
                                 Date due_date,
                                 String purchaser_name,
                                 String mobile,
                                 String area_code,
                                 String product_name,
                                 String order_num,
                                 BigDecimal sale_price,
                                 Date install_date,
                                 String powder_color){
        SaleOrder order = new SaleOrder(id,due_date, purchaser_name, mobile, area_code, product_name, order_num, sale_price, install_date, powder_color);
        try{
            orderDao.save(order);
        }catch (Exception e){
            System.out.println("Update order error");
            return false;
        }
        return true;
    }

    public boolean deleteOrder(Integer id){
        try{
            orderDao.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
