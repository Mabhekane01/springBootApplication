package com.assessment.grad001.bheki.ngwenya.restful.services;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository; // Ensure this field is properly injected.

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public Investor saveInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    public Optional<Investor> getInvestorsByEmail(String email) {
        return investorRepository.findByEmail(email);
    }

}
