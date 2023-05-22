package com.SpringBoot.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class paymentRequest {

    private Long orderId;
    private Long amount;
    private String referenceNumber;
    private paymentType PaymentType;
}
