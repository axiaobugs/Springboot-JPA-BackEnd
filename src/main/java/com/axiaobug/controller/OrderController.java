package com.axiaobug.controller;

import com.axiaobug.pojo.Employees;
import com.axiaobug.pojo.SaleOrder;
import com.axiaobug.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //Goto the order page
    @GetMapping("/order")
    public String order(Model model){
        List<SaleOrder> allOrder = orderService.getAllOrder();
        model.addAttribute("allOrder",allOrder);
        return "order/order";
    }


    //Goto the add page
    @GetMapping("/order/edit")
    public String toAddOrder() {
        return "order/add";
    }


    //Add a order
    @PostMapping("/order/edit")
    public String addOrder(@RequestParam("due_date") String due_date,
                           @RequestParam("purchaser_name") String purchaser_name,
                           @RequestParam("mobile") String mobile,
                           @RequestParam("area_code") String area_code,
                           @RequestParam("product_name") String product_name,
                           @RequestParam("order_num") String order_num,
                           @RequestParam("sale_price")BigDecimal sale_price,
                           @RequestParam("install_date") String install_date,
                           @RequestParam(name = "powder_color",defaultValue = "null") String powder_color) throws ParseException {
        Date due = sdf.parse(due_date);
        Date install;
        System.out.println(install_date);
        if(install_date.isEmpty()){
            install=sdf.parse(due_date);
        }else{
            install=sdf.parse(install_date);
        }
        System.out.println(install.toString());
        orderService.addOrder(due,purchaser_name,mobile,area_code,product_name,order_num,sale_price,install,powder_color);
        return "redirect:/order";
    }

    //Goto  update employee page
    @GetMapping ("/order/edit/{order_id}")
    public String toUpdateOrder(@PathVariable("order_id") Integer id,
                                   Model model){
        SaleOrder order = orderService.getOrderById(id);
        model.addAttribute("order",order);
        return "order/update";
    }

    //Update a order
    @PutMapping("/order/edit")
    public String updateOrder(@RequestParam("order_id") Integer id,
                              @RequestParam("due_date") String due_date,
                              @RequestParam("purchaser_name") String purchaser_name,
                              @RequestParam("mobile") String mobile,
                              @RequestParam("area_code") String area_code,
                              @RequestParam("order_num") String order_num,
                              @RequestParam("product_name") String product_name,
                              @RequestParam("sale_price")BigDecimal sale_price,
                              @RequestParam("install_date") String install_date,
                              @RequestParam(name = "powder_color",defaultValue = "null") String powder_color) throws ParseException {
        Date due = sdf.parse(due_date);
        Date install;
        if(install_date.isEmpty()){
            install=sdf.parse(due_date);
        }else{
            install=sdf.parse(install_date);
        }
        orderService.updateOrder(id,due,purchaser_name,mobile,area_code,product_name,order_num,sale_price,install,powder_color);
        return "redirect:/order";
    }


    @DeleteMapping ("/order/edit/{order_id}")
    public String deleteOrder(@PathVariable("order_id") Integer id){
        orderService.deleteOrder(id);
        return "redirect:/order";
    }

}
