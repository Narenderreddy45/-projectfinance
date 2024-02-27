package personalfinanceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personalfinance.model.Expenses;
import personalfinancerepository.ExpensesRepository;
import java.util.List;
@Service
public class ExpensesService {
	@Autowired
    private  ExpensesRepository expenseRepository;
	
	Expenses expense;
    //public ExpensesService(ExpensesRepository expenseRepository) {
      // this.expenseRepository = expenseRepository;
   //}
    public List<Expenses> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expenses createExpense(Expenses expense) {
    return expenseRepository.save(expense);
    }
    public Expenses getExpenses(Long expensesId) {
    	Expenses expense =expenseRepository.findById(expensesId).get();
    	return expense;
    	
    }
    public Expenses updateExpense(Long expenseId, Expenses updatedExpense) {
    	Expenses existingExpense = (expenseRepository.findById(expenseId)).orElse(null);
       
        if (existingExpense != null) {
            existingExpense.setDescription(updatedExpense.getDescription());
            existingExpense.setAmount(updatedExpense.getAmount());
            return expenseRepository.save(existingExpense);	
        }
        return null; 
    }
    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }
    
}