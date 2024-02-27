package personalfinancerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personalfinance.model.Income;
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    
}