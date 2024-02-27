package personalfinance.model;
import java.math.BigDecimal;
import java.time.Year;
public class IncomeProjection {
	   		public IncomeProjection() {
			// TODO Auto-generated constructor stub
		}
		private BigDecimal projectedAmount;
		private Year year;
	    private double growthRate;
		
	    public void setYear(Year year) {
			this.year = year;
		}
		public BigDecimal getProjectedAmount() {
			return projectedAmount;
		}
		public void setProjectedAmount(BigDecimal projectedAmount) {
			this.projectedAmount = projectedAmount;
		}
		public Year getYear() {
			return year;
		}
		
		public double getGrowthRate() {
			return growthRate;
		}
		public void setGrowthRate(double growthRate) {
			this.growthRate = growthRate;
		}
		public void setYear(int i) {
			// TODO Auto-generated method stub
			
		}
}