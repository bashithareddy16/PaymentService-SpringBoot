package com.SpringBoot.PaymentService.service;

import com.SpringBoot.PaymentService.model.paymentRequest;
import com.SpringBoot.PaymentService.model.paymentResponse;

public interface paymentService {
    paymentResponse getPaymentDetailsbyOrderId(Long orderId);
    long doPayment(paymentRequest paymentRequest);
}
