package helper;

import java.util.Scanner;

public class ValidateInput {

	public static int integer() {
		int num=0;
		boolean flag;
		Scanner scan = new Scanner (System.in);
		
		for(flag=false;flag==false;) {
			if(scan.hasNextInt()) {
				num=scan.nextInt();
				flag=true;
			}else{
				System.out.print("Please, enter a valid number.\n");
				scan.next();
			}
		}
		return num;
	}

	public static double decimal() {
		double num=0;
		boolean flag;
		Scanner scan = new Scanner (System.in);
		
		for(flag=false;flag==false;) {
			if(scan.hasNextDouble()) {
				num=scan.nextDouble();
				flag=true;
			}else{
				System.out.print("Please, enter a valid number.\n");
				scan.next();
			}
		}
		return num;
	}

	public static boolean logic() {
		boolean flag,out=false;
		Scanner scan = new Scanner (System.in);
		
		for(flag=false;flag==false;) {
			if(scan.hasNextBoolean()) {
				out=scan.nextBoolean();
				flag=true;
			}else{
				System.out.print("Please, enter a valid boolean.\n");
				scan.next();
			}
		}
		return out;
	}
	
	public static void main(String[] args) {
		boolean test;
		
		System.out.print("Insert a boolean: ");
		test=logic();
		System.out.print(test);
	}
}
