package personalfinancerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personalfinance.model.Expense;
@Repository
public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    
}