package personalfinance.personalfinanceproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personalfinance.personalfinanceproject.model.Expense;
import personalfinance.personalfinanceproject.repository.ExpensesRepository;
import java.util.List;
@Service
public class ExpenseService {
	@Autowired
    private  ExpensesRepository expenseRepository;
	
	Expense expense;
    //public ExpensesService(ExpensesRepository expenseRepository) {
      // this.expenseRepository = expenseRepository;
   //}
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public Expense createExpense(Expense expense) {
    return expenseRepository.save(expense);
    }
    public Expense getExpenses(Long expensesId) {
    	Expense expense =expenseRepository.findById(expensesId).get();
    	return expense;
    	
    }
    public Expense updateExpense(Long expenseId, Expense updatedExpense) {
    	Expense existingExpense = (expenseRepository.findById(expenseId)).orElse(null);
       
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