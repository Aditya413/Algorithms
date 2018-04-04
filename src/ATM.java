import java.util.Scanner;

class ATM {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		ATM atm = new ATM();
		int withDrawlAmount = sc.nextInt();
		sc.skip("\\s");
		double accountBal = sc.nextDouble();
		sc.close();
		boolean flag = withDrawlAmount > 0 &&  withDrawlAmount <= 2000 && accountBal > 0 &&  accountBal <= 2000? true:false;
		if(flag){
			System.out.println(atm.transaction(withDrawlAmount, accountBal));
		} else {
			
		}
	}
	
	public double transaction(double withDrawlAmount, double accountBal){
		double finalOutput = 0;
		double transfee = 0.50;
		if(withDrawlAmount < accountBal){
			if(withDrawlAmount % 5 == 0){
				finalOutput = accountBal-withDrawlAmount;
				finalOutput = finalOutput-transfee;
			} else{
				finalOutput = accountBal;
			}
		} else {
			finalOutput = accountBal;
		}
		
		return finalOutput;
	}
}
