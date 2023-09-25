package com.assessment.grad001.bheki.ngwenya.restful.repositories;
import com.assessment.grad001.bheki.ngwenya.restful.models.Investor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("investor")
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
    <Optional> java.util.Optional<Investor> findByEmail(String email) ;

    @Query("SELECT i.age FROM Investor i WHERE i.investor_id = :investorId")
    Integer findAgeByInvestorId(@Param("investorId") Integer investorId);


}
