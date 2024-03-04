package personalfinance.personalfinanceproject.service;

import personalfinance.personalfinanceproject.repository.IncomeRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personalfinance.personalfinanceproject.model.Income;
import personalfinance.personalfinanceproject.model.IncomeProjection;
import personalfinance.personalfinanceproject.exception.UserNotFoundException;

@Service
public class IncomeServiceImpl implements IncomeService {
	@Autowired
	 IncomeRepository incomeRepository;
    @Autowired
    UserService userService;
    @Override
    public Income addIncome(Income income) {
    	if (userService.getUser(income.getUserId()) != null) {
    		 return incomeRepository.save(income);
    	}	 
    	throw new UserNotFoundException("User Not Found");
    }
	@Override
	public List<Income> getIncome(Long userId) {
		// TODO Auto-generated method stub
		return incomeRepository.findByUserId(userId);	
	}
	@Override
	public List<IncomeProjection> calculateIncomeProjection(Long userId, int years) {
		// TODO Auto-generated method stub
		List<IncomeProjection> projections = new ArrayList<>();
		List<Income> incomes =getIncome(userId);
		Double totalIncome = 0d;
		for(Income income:incomes) {
			if ("Annually".equals(income.getFrequency())) {
				totalIncome =totalIncome+income.getAmount();
			}
			if ("Monthly".equals(income.getFrequency())) {
				 totalIncome =totalIncome+(income.getAmount()*12);
			}
		}
		for(int i=1;i<=years;i++) {
			IncomeProjection projection =new IncomeProjection();
			projection.setYear(i);
			projection.setGrowthRate(3d);
			 totalIncome = totalIncome *1.03;
			  projection.setProjectedAmount(totalIncome);
			  projections.add(projection);
		}
		return projections;
	}
	public List<Income> getIncomeSources() {
		// TODO Auto-generated method stub
		return null;
	}
	public double calculateTotalIncome() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// we can also add more service methods as needed, like
	// calculateIncomeProjection, updateIncome, deleteIncome, etc.
}
