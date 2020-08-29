// instance variables
		private String companyName;
		private int empRate;
		private int numOfWorkingDays;
		private int maxHrsInMonth;
		private int totalEmpWage;

		public EmpWageInstance(final String companyName, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth) {
			
			this.companyName=companyName;
			this.empRate = empRate;
			this.numOfWorkingDays = numOfWorkingDays;
			this.maxHrsInMonth = maxHrsInMonth;
		}

		public static void main(String[] args) {
			final EmpWageUc9 ewMicrosoft = new EmpWageUc9("Microsoft", 20, 20, 100);
			ewMicrosoft.computeEmpWage();
			System.out.println("Total Emp Wage of Microsift company=" + ewMicrosoft);

			final EmpWageUc9 ewApple = new EmpWageInstance("Apple", 20, 18, 100);
			ewApple.computeEmpWage();
			System.out.println("Total Emp Wage of Apple company=" + ewApple);

			final EmpWageUc9 ewHtc = new EmpWageInstance("Htc", 20, 20, 120);
			ewHtc.computeEmpWage();
			System.out.println("Total Emp Wage of Htc Company=" + ewHtc);
		}

		/**
		 * calculate employee daily wages based on type of employee
		 */

		public int computeEmpWage() {

			// local Variables
			int totalWage = 0;
			int totalEmpHrs = 0;
			int totalWorkingDays = 0;
			while (totalEmpHrs < maxHrsInMonth && totalWorkingDays < numOfWorkingDays) {
				totalWorkingDays++;

				final int empHrs = getEmpHrs();
				final int empWage = empHrs * empRate;
				totalEmpHrs = empHrs;
				totalWage = empWage;
				System.out.println("EMP day=" + totalWorkingDays + "wages=" + empWage);
			}
			totalEmpWage=totalWage;
		}

		/* @return employee hrs */
		public int getEmpHrs() {

			// local variables
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
