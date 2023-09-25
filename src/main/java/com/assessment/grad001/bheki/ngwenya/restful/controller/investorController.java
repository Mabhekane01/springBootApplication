package com.assessment.grad001.bheki.ngwenya.restful.controller;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import com.assessment.grad001.bheki.ngwenya.restful.services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/investor")
public class investorController {
    private final InvestorService investorService;

    @Autowired
    public investorController(InvestorService investorService) {
        this.investorService = investorService;
    }
    @PostMapping("/addInvestor")
    public Investor addInvestor(@RequestBody Investor investor) {
        return investorService.saveInvestor(investor);
    }

    @GetMapping("/getInvestor")
    public ResponseEntity<Optional<Investor>> getInvestorsByPersonal(@RequestParam String email) {
        Optional<Investor> investor = investorService.getInvestorsByEmail(email);
        if (investor.isPresent()) {
            return ResponseEntity.ok(investor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}