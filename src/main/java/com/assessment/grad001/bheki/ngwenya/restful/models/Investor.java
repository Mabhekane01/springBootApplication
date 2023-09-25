package com.assessment.grad001.bheki.ngwenya.restful.models;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="investor")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer investor_id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private  String username;

    @Column(columnDefinition = "INT", nullable = true)
    private Integer age;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String address;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String contact;
    // getters and setters
}
