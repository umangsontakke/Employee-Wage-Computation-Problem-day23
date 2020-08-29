public class EmpWageInstance {
	
	//instance variables

	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;

	//instance method
	public EmpWageInstance(final int empRate, final int numOfWorkingDays, final int maxHrsInMonth) {
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	}

	public static void main(String[] args) {
		final EmpWageInstance ewi = new EmpWageInstance(20, 20, 100);
		ewi.caldailyEmpWage();
	}

	/**
	 * calculate employee daily wages based on type of employee
	 */

	public void caldailyEmpWage() {
		
		//local variables
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while (totalEmpHrs < maxHrsInMonth && totalWorkingDays<numOfWorkingDays) {
			totalWorkingDays++;

			final int empHrs = getEmpHrs();
			final int empWage = empHrs * empRate;
			totalEmpHrs = empHrs;
			totalWage = empWage;
			System.out.println("EMP day=" + totalWorkingDays + "wages=" + empWage);
		}
		System.out.println("Total emp Wage=" + totalWage);
	}

	/* @return employee hrs */
	public int getEmpHrs() {
		
		//local variables
		
		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

                //get random value
		final double randomValue = Math.floor(Math.random() * 10) % 3;

		switch ((int) randomValue) {

		case isFullTime:
			empHrs = 8;
			System.out.println("Emp is Present for full time");
			break;
		case isPartTime:
			empHrs = 4;
			break;
		default:
			System.out.println("Emp is absent");
			break;

		}
		return empHrs;

	}
}
