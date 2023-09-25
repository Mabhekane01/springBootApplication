package com.assessment.grad001.bheki.ngwenya.restful.models;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "investor_id", columnDefinition = "INT", nullable = false)
    private Investor investorId;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String type;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(columnDefinition = "DOUBLE")
    private Double current_balance;
    // getters and setters



}
