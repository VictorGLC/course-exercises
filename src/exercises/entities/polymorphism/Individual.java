package exercises.entities.polymorphism;

public class Individual extends TaxPayer {
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	public Double getNumberOfEmployees() {
		return healthExpenditures;
	}
	public void setNumberOfEmployees(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public double tax() {
		double tax = 0;
		if(getAnualIncome() < 20000) {
			tax = getAnualIncome() * 0.15;
		} else if(getAnualIncome() >= 20000) {
			tax = getAnualIncome() * 0.25;
		}else if(healthExpenditures > 0) {
			tax = tax - (healthExpenditures * 0.5);
		}
		return tax;
	}
}
