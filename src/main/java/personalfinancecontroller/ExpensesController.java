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
import personalfinance.model.Expenses;
import personalfinanceservice.ExpensesService;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
	private final ExpensesService expensesService;

	public ExpensesController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}

//@PostMapping("/log")
//public ResponseEntity<Expenses>logExpense(@RequestBody Expenses expenses){
//	Expenses loggedExpense =ExpensesService.logExpense(expenses);
	// return new ResponseEntity<>(loggedExpense,HttpStatus.CREATED);
//}
	@PostMapping("/Create")
	public Expenses createuser(@RequestBody Expenses expenses) {
		return expensesService.createExpense(expenses);
	}

	@GetMapping("/{expenseId")
	public ResponseEntity<Expenses> getExpenses(@PathVariable Long ExpensesId) {
		Expenses expenses = expensesService.getExpenses(ExpensesId);
		if (expenses != null) {
			return new ResponseEntity<>(expenses, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(expenses, HttpStatus.NOT_FOUND);
		}
	}

//@GetMapping
//public ResponseEntity<List<Expenses>> getExpenses(){
//	List<Expenses> expenses =expensesService.getExpenses();
//	return new ResponseEntity<>(expenses, HttpStatus.OK);	
//}
	@PutMapping("/{expenseId}")
	public ResponseEntity<Expenses> updateExpense(@PathVariable Long expenseId, @RequestBody Expenses updateExpense) {
		Expenses updated = expensesService.updateExpense(expenseId, updateExpense);
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
