package personalfinanceservice;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import personalfinance.model.IncomeProjection;

@Service
public class ProjectionService {
	
public IncomeProjection calculateProjection( IncomeProjection incomeprojection) {
	IncomeProjection projection =new IncomeProjection();
	projection.setProjectedAmount(getIncome());
	projection.setYear(2024);
	projection.setGrowthRate(0.1);
	return projection;
}
private BigDecimal getIncome() {
	// TODO Auto-generated method stub
	return null;
}
public IncomeProjection calculateProjection(){
	return null;
}
}