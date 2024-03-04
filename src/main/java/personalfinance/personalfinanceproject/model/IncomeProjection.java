package personalfinance.personalfinanceproject.model;
import java.time.Year;
public class IncomeProjection {
	   		public IncomeProjection() {
			// TODO Auto-generated constructor stub
		}
		private Double projectedAmount;
		private Year year;
	    private double growthRate;
		
	    public void setYear(Year year) {
			this.year = year;
		}
		public Double getProjectedAmount() {
			return projectedAmount;
		}
		public void setProjectedAmount(Double totalIncome) {
			this.projectedAmount = totalIncome;
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