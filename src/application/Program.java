package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account account = null;
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			
			account.withdraw(amount);
			System.out.println(account);
		}
		catch(DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Number invalid!");
		}
		sc.close();
	}

}
