package com.SpringBoot.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class paymentResponse {

    private long paymentId;
    private String paymentStatus;
    private paymentType PaymentType;
    private long amount;
    private Instant paymentDate;
    private long orderId;
}
