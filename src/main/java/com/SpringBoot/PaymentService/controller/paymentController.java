package com.SpringBoot.PaymentService.controller;

import com.SpringBoot.PaymentService.model.paymentRequest;
import com.SpringBoot.PaymentService.model.paymentResponse;
import com.SpringBoot.PaymentService.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class paymentController {
    @Autowired
    private paymentService PaymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody paymentRequest paymentRequest) {
        return new ResponseEntity<>(PaymentService.doPayment(paymentRequest), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<paymentResponse> getPaymentDetailsbyOrderId(@PathVariable String orderId){
        return new ResponseEntity<>(
                PaymentService.getPaymentDetailsbyOrderId(orderId),
                HttpStatus.OK);
    }
}
