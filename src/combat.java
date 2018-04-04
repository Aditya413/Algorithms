import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class combat {
	public static void main(String args[]){
		int totalNumWarriors;
		Scanner sc = new Scanner(System.in);
		combat c = new combat();
		List<Integer> returnList = new ArrayList<Integer>();
		System.out.println("Please enter the number of warriors");
		totalNumWarriors = sc.nextInt();
		int [] powerArray = new int[totalNumWarriors];
		System.out.println("Please start entering power..");
		for(int i=0; i < powerArray.length; i++){
			powerArray[i] = sc.nextInt();
		}
		sc.close();
		if(totalNumWarriors >= 4){
			breakOuterLoop:
				for(int i=0; i<powerArray.length; i++){
					for(int j=i+1; j<powerArray.length; j++){
						int sum = powerArray[i] + powerArray[j];
						returnList = c.combatMechanism(sum, powerArray, j+1);
						if(returnList.get(0)!=-1){
							returnList.add(powerArray[i]);
							returnList.add(powerArray[j]);
							break breakOuterLoop;
						}
					}
				}
		} else {
			returnList.add(-1);
		}
		
		System.out.println("The output of this is :");
		System.out.println(Arrays.toString(returnList.toArray()));
	}
	
	public List<Integer> combatMechanism(int sum, int [] powerArray, int k){
		List<Integer> returnList = new ArrayList<Integer>();
			outerBreakPoint:
			for(int i=k; i<powerArray.length; i++){
				for(int j=i+1; j<powerArray.length; j++){
					if(sum == powerArray[i]+powerArray[j]){
						returnList.add(powerArray[i]);
						returnList.add(powerArray[j]);
						break outerBreakPoint;
					}
				}
			}
		if(returnList.size()==0){
			returnList.add(-1);
		}
		return returnList;
	}
}
