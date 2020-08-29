kpublic class DailyEmpWage
{
	public static void main(String[] arg)
	{
                  //Constants
		int fullTimeEmp=1;
		int EMP_RATE_PER_HOUR=20;
			//Variables
		int empHrs=0;
		int empWage=0;
			//Computation
		int empCheck=(Math.random()*10)%2;
		if(empCheck==IS_FULL_TIME)
		empHrs=8;
		else
		empHrs=0;
		empWage=empHrs*EMP_RATE_PER_HOUR;
		System.out.println("Emp Wage="+empWage);
	    	

	}

}
