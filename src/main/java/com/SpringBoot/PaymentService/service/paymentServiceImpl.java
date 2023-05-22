package com.SpringBoot.PaymentService.service;

import com.SpringBoot.PaymentService.entity.transactionDetails;
import com.SpringBoot.PaymentService.model.paymentRequest;
import com.SpringBoot.PaymentService.model.paymentResponse;
import com.SpringBoot.PaymentService.model.paymentType;
import com.SpringBoot.PaymentService.repository.transactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class paymentServiceImpl implements paymentService{

    @Autowired
    private transactionDetailsRepository transactionDetailsRepository;

    @Override
    public paymentResponse getPaymentDetailsbyOrderId(Long orderId) {
        log.info("getting payment details for the order ID: {}");
        transactionDetails Transactiondetails = transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));

        paymentResponse PaymentResponse = paymentResponse.builder()
                .paymentId(Transactiondetails.getId())
                .orderId(Transactiondetails.getOrderId())
                .PaymentType(paymentType.valueOf(Transactiondetails.getPaymentType()))
                .paymentDate(Transactiondetails.getPaymentDate())
                .status(Transactiondetails.getPaymentStatus())
                .amount(Transactiondetails.getAmount())
                .build();

        return PaymentResponse;
    }

    @Override
    public long doPayment(paymentRequest paymentRequest) {
        log.info("Recording payment details: {} ", paymentRequest);

        transactionDetails TransactionDetails = transactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentType(paymentRequest.getPaymentType().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetailsRepository.save(TransactionDetails);
        log.info("Transaction completed with ID{} " , TransactionDetails.getId());
        return TransactionDetails.getId();
    }
}
