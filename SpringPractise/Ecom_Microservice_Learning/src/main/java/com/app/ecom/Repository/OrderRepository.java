package com.app.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecom.Model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
