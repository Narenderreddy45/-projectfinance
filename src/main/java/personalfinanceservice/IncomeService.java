package personalfinanceservice;

import personalfinancerepository.IncomeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personalfinance.model.Income;

@Service
public class IncomeService {
	@Autowired
	private final IncomeRepository incomeRepository;

	public IncomeService(IncomeRepository incomeRepository) {
		this.incomeRepository = incomeRepository;
	}

	public Income addIncome(Income income) {
		return incomeRepository.save(income);
	}

	public List<Income> getIncomeSources() {
		return incomeRepository.findAll();
	}

	public double calculateTotalIncome() {
		List<Income> incomes = incomeRepository.findAll();
		double totalIncome = 0;
		for (Income income : incomes) {
			totalIncome += income.getAmount();
		}
		return totalIncome;
	}

	// we can also add more service methods as needed, like
	// calculateIncomeProjection, updateIncome, deleteIncome, etc.
}
