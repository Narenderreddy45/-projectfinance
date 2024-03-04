package personalfinance.personalfinanceproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personalfinance.personalfinanceproject.model.Income;
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

	List<Income> findByUserId(Long userId);
    
}