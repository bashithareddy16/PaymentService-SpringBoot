package com.SpringBoot.PaymentService.repository;

import com.SpringBoot.PaymentService.entity.transactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionDetailsRepository extends JpaRepository<transactionDetails, Long> {

    transactionDetails findByOrderId(long orderId);

}
