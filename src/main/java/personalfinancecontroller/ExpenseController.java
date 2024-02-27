package personalfinancecontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personalfinance.model.Expense;
import personalfinanceservice.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	private final ExpenseService expensesService;

	public ExpenseController(ExpenseService expensesService) {
		this.expensesService = expensesService;
	}

//@PostMapping("/log")
//public ResponseEntity<Expenses>logExpense(@RequestBody Expenses expenses){
//	Expenses loggedExpense =ExpensesService.logExpense(expenses);
	// return new ResponseEntity<>(loggedExpense,HttpStatus.CREATED);
//}
	@PostMapping("/Create")
	public Expense createuser(@RequestBody Expense expense) {
		return expensesService.createExpense(expense);
	}

	@GetMapping("/{expenseId}")
	public ResponseEntity<Expense> getExpense(@PathVariable Long ExpenseId) {
		Expense expense = expensesService.getExpenses(ExpenseId);
		if (expense != null) {
			return new ResponseEntity<>(expense, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(expense, HttpStatus.NOT_FOUND);
		}
	}

//@GetMapping
//public ResponseEntity<List<Expenses>> getExpenses(){
//	List<Expenses> expenses =expensesService.getExpenses();
//	return new ResponseEntity<>(expenses, HttpStatus.OK);	
//}
	@PutMapping("/{expenseId}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseId, @RequestBody Expense updateExpense) {
		Expense updated = expensesService.updateExpense(expenseId, updateExpense);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{expenseId}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long expenseId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
