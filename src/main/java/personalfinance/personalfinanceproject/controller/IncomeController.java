package personalfinance.personalfinanceproject.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personalfinance.personalfinanceproject.model.Income;
import personalfinance.personalfinanceproject.service.IncomeServiceImpl;
@RestController
@RequestMapping("/income")
public class IncomeController {
 private final IncomeServiceImpl incomeService;
 public IncomeController(IncomeServiceImpl incomeService) {
	this.incomeService = incomeService;	 
 }
 @PostMapping("/add")
 public ResponseEntity<Income> addIncome (@RequestBody Income income){
	 Income addedIncome = incomeService.addIncome(income);
	 return new ResponseEntity<>(addedIncome,HttpStatus.CREATED);
 }
 @GetMapping
 public ResponseEntity<List<Income>> getIncomeSources(){
	 List<Income>incomeSources =incomeService.getIncomeSources();
	 return new ResponseEntity<>(incomeSources,HttpStatus.OK); 
 }
 @GetMapping("/total")
 public ResponseEntity<Double> calculateTotalIncome(){
	 double totalIncome =incomeService.calculateTotalIncome();
	 return new ResponseEntity<>(totalIncome,HttpStatus.OK);
   }
 }