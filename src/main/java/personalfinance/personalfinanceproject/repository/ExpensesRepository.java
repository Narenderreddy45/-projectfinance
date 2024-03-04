package personalfinance.personalfinanceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personalfinance.personalfinanceproject.model.Expense;
@Repository
public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    
}