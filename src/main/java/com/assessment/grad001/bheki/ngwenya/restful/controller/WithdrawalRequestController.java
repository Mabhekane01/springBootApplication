package com.assessment.grad001.bheki.ngwenya.restful.controller;
import com.assessment.grad001.bheki.ngwenya.restful.services.WithdrawalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
public class WithdrawalRequestController {

    private final WithdrawalRequestService service;

    @Autowired
    public WithdrawalRequestController(WithdrawalRequestService service){
        this.service = service;
    }


    @GetMapping("/getValidations")
    public ResponseEntity<Integer> getProductsByInvestorEmail(@RequestParam String investorEmail, @RequestParam String type, @RequestParam Double amount, @RequestParam String bankName, @RequestParam Integer accountNumber) {
        Integer product = service.getValidationInfo(investorEmail, type, amount, bankName, accountNumber);
        if (product !=null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
