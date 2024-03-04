package personalfinance.personalfinanceproject.service;

import java.util.List;

import personalfinance.personalfinanceproject.model.Income;
import personalfinance.personalfinanceproject.model.IncomeProjection;

public interface IncomeService {

	Income addIncome(Income income);
    List<Income> getIncome(Long userId);
    List<IncomeProjection>calculateIncomeProjection(Long userId,int years);
}
