package com.axiaobug.dao;

import com.axiaobug.pojo.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDao extends JpaRepository<SaleOrder,Integer>, JpaSpecificationExecutor<SaleOrder> {
}
