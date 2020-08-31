import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

interface EmpWageBuilder{

	void addCompany(final String name,final int empRate, final int numOfWorkingDays,final int maxHrsInMonth);
	void computeEmpWage();
	
}

public class EmpWageUc13 {
	
	private List<Company> companies;
	private Map<String, Integer>companyWages;

	public EmpWageUc13() {
		companies = new ArrayList<Company>();
		companyWages=new HashMap<String, Integer>();
	}

	public static void main(String[] args) {
		System.out.println("Starting...");
		final EmpWageUc12 empBuilder = new EmpWageUc12();
		empBuilder.addCompany("Apple", 20, 20, 100);
		empBuilder.addCompany("Microsoft", 20, 18, 110);

		empBuilder.computeEmpWage();
				
	}

	@Override
	public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth) {
		System.out.println("Called add company function with name : " + name);
		companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
	}

	@Override
	private void computeEmpWage() {

		System.out.println("Called computeEmpWage --->");
		for (int i = 0; i < companies.size(); i++) {
			final Company company = companies.get(i);
			final int totalWage = computeEmpWage(company);
			company.setTotalEmpWage(totalWage);
			companyWages.put(company.getName(), totalWage);
		
		}
		System.out.println("Stored values in map--->"+companyWages.toString());

	}

	/**
	 * calculate total employee wages
	 * 
	 * @param company The Company
	 * @return total employee wages.
	 */
	private int computeEmpWage(final Company company) {
		System.out.println("Calculating company wage for company : " + company.getName());
		
		//local variables
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while (totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays < company.getNumOfWorkingDays()) {
			totalWorkingDays++;

			final int empHrs = getEmpHrs();
			final int empWage = empHrs * company.getEmpRate();
			totalEmpHrs += empHrs;
			totalWage += empWage;
			// System.out.println("Emp DAY : "+totalWorkingDays+" wages : "+empWage);
		}
		return totalWage;
	}

	/**
	 * Get employee hours.
	 * 
	 * @return employee hrs
	 */
	public int getEmpHrs() {

		
		//local variables
		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

		// get random value
		final double randomValue = Math.floor(Math.random() * 10) % 3;

		switch ((int) randomValue) {

		case isFullTime:
			empHrs = 8;
			// System.out.println("Emp is present for full time.");
			break;
		case isPartTime:
			empHrs = 4;
			// System.out.println("Emp is present for part time.");
			break;
		default:
			// System.out.println("Emp is absent");
			break;
		}
		return empHrs;
	}

}

/**
 * CompanyEmpWage
 */
class Companys {

	//instance variables
	private String name;
	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;

	public Companys(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth) {
		this.name = name;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	}

	public String getName() {
		return this.name;
	}

	public int getEmpRate() {
		return this.empRate;
	}

	public int getNumOfWorkingDays() {
		return this.numOfWorkingDays;
	}

	public int getMaxHrsInMonth() {
		return this.maxHrsInMonth;
	}

	public void setTotalEmpWage(final int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}

	@Override
	public String toString() {
		return "Total emp wage for company: " + name + " is " + totalEmpWage;
	}
	
}
