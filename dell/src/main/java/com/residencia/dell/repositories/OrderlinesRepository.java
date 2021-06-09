package com.residencia.dell.repositories;

import com.residencia.dell.entities.Orderlines;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderlinesRepository extends JpaRepository<Orderlines,Integer> {

//    Orderlines findByOrderlineIdAndOrderId(Integer orderLineId, Orders ordersId);
//    Orderlines findByOrderIdAndOrderIdAndProdId(Integer orderlineId,Integer orderId,Integer prodId);
//
//    List<Orderlines> findByProdId(Integer prodI);


}
