package com.assessment.grad001.bheki.ngwenya.restful.services;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import com.assessment.grad001.bheki.ngwenya.restful.models.Product;
import com.assessment.grad001.bheki.ngwenya.restful.errorControl.InvestorExceptions;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.InvestorRepository;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvestorRepository investorRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductsByInvestorEmail(String investorEmail) {
        // Find the investor by email
        Optional<Investor> investorOptional = investorRepository.findByEmail(investorEmail);
        if (investorOptional.isPresent()) {
            Investor investor = investorOptional.get();

            // Get products by investor ID
            return productRepository.findProductsByInvestorId(investor);
        } else {
            // Handle the case where the investor is not found
            throw new InvestorExceptions("Investor with email " + investorEmail + " not found.");
        }
    }
}
