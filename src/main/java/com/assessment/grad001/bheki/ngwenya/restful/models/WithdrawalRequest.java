package com.assessment.grad001.bheki.ngwenya.restful.models;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="withdrawal_request")
public class WithdrawalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer withdrawal_Request_id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "investor_id", columnDefinition = "INT", nullable = false)
    private Investor investorId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "product_id", columnDefinition = "INT", nullable = false)
    private Product productId;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String bank_name;

    @Column (columnDefinition = "INT", nullable = false)
    private Integer account_number;

    @Column (columnDefinition = "DOUBLE", nullable = false)
    private Double withdrawal_amount;
    @CreationTimestamp
    @Column (name = "date_time", nullable = false)
    private LocalDateTime date_time;
}
