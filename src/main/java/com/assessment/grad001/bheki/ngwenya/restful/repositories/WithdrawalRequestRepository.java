package com.assessment.grad001.bheki.ngwenya.restful.repositories;
import com.assessment.grad001.bheki.ngwenya.restful.models.WithdrawalRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("products")
public interface WithdrawalRequestRepository extends JpaRepository<WithdrawalRequest, Integer> {
    @Query("SELECT p.type FROM Product p WHERE p.id = :productId")
    String findTypeByProductId(@Param("productId") Long productId);
}
