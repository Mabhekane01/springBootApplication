package com.assessment.grad001.bheki.ngwenya.restful.repositories;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import com.assessment.grad001.bheki.ngwenya.restful.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("products")
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findProductsByInvestorId(Investor investorId);
    Product findProductByInvestorIdAndType(Investor investorId, String type);
}
