package com.assessment.grad001.bheki.ngwenya.restful.services;
import com.assessment.grad001.bheki.ngwenya.restful.errorControl.InvestorExceptions;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import com.assessment.grad001.bheki.ngwenya.restful.models.Product;
import com.assessment.grad001.bheki.ngwenya.restful.models.WithdrawalRequest;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.InvestorRepository;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.ProductRepository;
import com.assessment.grad001.bheki.ngwenya.restful.repositories.WithdrawalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class WithdrawalRequestService{
    private final InvestorRepository investorRepository;

    private final WithdrawalRequestRepository requestRepository;
    private final ProductRepository productRepository;

    @Autowired
    public WithdrawalRequestService(WithdrawalRequestRepository requestRepository, InvestorRepository investorRepository, ProductRepository productRepository) {
        this.investorRepository = investorRepository;
        this.productRepository = productRepository;
        this.requestRepository = requestRepository;
    }

    public Integer getValidationInfo(String investorEmail, String type, Double amount, String bankName, Integer accountNumber) {
        // Find the investor by email
        Optional<Investor> investorOptional = investorRepository.findByEmail(investorEmail);
        if (investorOptional.isPresent()) {
            Investor investor = investorOptional.get();
            Product product = productRepository.findProductByInvestorIdAndType(investor, type);
            if (product !=null){
                Integer age = investorRepository.findAgeByInvestorId(investor.getInvestor_id());

                if(Objects.equals(product.getType(), "Retirement")){
                    if (age>65){
                        if (product.getCurrent_balance() < amount){
                            throw new InvestorExceptions("Investor with email " + investorEmail + "  Amount accedes balance.");
                        }else{
                            double totalAmount = amount/ product.getCurrent_balance();
                            if (totalAmount > 0.9 ){
                                throw new InvestorExceptions("Investor with email " + investorEmail + "  Amount accedes 90% of the balance.");
                            }else{

                                WithdrawalRequest withdrawalRequest= new WithdrawalRequest();
                                withdrawalRequest.setInvestorId(investor);
                                withdrawalRequest.setProductId(product);
                                withdrawalRequest.setBank_name(bankName);
                                withdrawalRequest.setAccount_number(accountNumber);
                                withdrawalRequest.setWithdrawal_amount(amount);
                                requestRepository.save(withdrawalRequest);

                                return 2000;
                            }
                        }
                    }else{
                        throw new InvestorExceptions("Investor with email " + investorEmail + "  Age does not pass.");
                    }

                }else{
                    if (product.getCurrent_balance() < amount){
                        throw new InvestorExceptions("Investor with email " + investorEmail + "  Amount accedes balance.");
                    }else{
                        double totalAmount = amount/ product.getCurrent_balance();
                        if (totalAmount > 0.9 ){
                            throw new InvestorExceptions("Investor with email " + investorEmail + "  Amount accedes 90% of the balance.");
                        }else{
                            WithdrawalRequest withdrawalRequest= new WithdrawalRequest();
                            withdrawalRequest.setInvestorId(investor);
                            withdrawalRequest.setProductId(product);
                            withdrawalRequest.setBank_name(bankName);
                            withdrawalRequest.setAccount_number(accountNumber);
                            withdrawalRequest.setWithdrawal_amount(amount);
                            requestRepository.save(withdrawalRequest);

                            return 2000;
                        }
                    }
                }
            }else{
                throw new InvestorExceptions("Investor with email " + investorEmail + "  No product Found.");

            }
        } else {
            // Handle the case where the investor is not found
            throw new InvestorExceptions("Investor with email " + investorEmail + " not found.");
        }
    }
}
