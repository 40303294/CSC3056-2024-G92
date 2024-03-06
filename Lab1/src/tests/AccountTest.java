/*
 * Class done by Lauren + chooiwen
 */

package tests;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {
	
	String account_number;
	String username_of_account_holder;
	String account_type;
	Date account_opening_date;
	
	public static void testConstructor() throws ParseException {
		
		// 1. setup
		String account_number = "00009479";
		String username_of_account_holder = "mike";
		String account_type = "Standard";
		LocalDateTime account_opening_date = LocalDateTime.of(2017,6,11,0,0);
		
		// 2. Exercise, Run the object under test (Constructor)
		Account testAccount = new Account(account_number, username_of_account_holder, account_type, account_opening_date);
		
		// 3. Verify (Assert)
		if (testAccount.getAccount_number() == account_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getUsername_of_account_holder() == username_of_account_holder)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsername_of_account_holder-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUsername_of_account_holder-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_type() == account_type)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getAccount_type-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testAccount.getAccount_opening_date() == account_opening_date)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getAccount_opening_date-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getAccount_opening_date-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
	}

	
	public static void testSetters() throws ParseException {
		
		// Asserts
		
		String account_number = "00004997";
		String username_of_account_holder = "Sam";
		String account_type = "Saving";
		LocalDateTime account_opening_date = LocalDateTime.of(2019,12,6,0,0);

		
		Account testAccount = new Account(account_number, username_of_account_holder, account_type, account_opening_date);
		
			// assert 1 == 2;
			assert testAccount.getAccount_number() == account_number;
			assert testAccount.getUsername_of_account_holder() == username_of_account_holder;
			assert testAccount.getAccount_type() == account_type;
			assert testAccount.getAccount_opening_date() == account_opening_date;
				
			System.out.println("\nAccount Number: " + account_number);
			System.out.println("Username of account holder: " + username_of_account_holder);
			System.out.println("Account Type: " + account_type);
			System.out.println("Account Opening Date: " + account_opening_date);
			
			System.out.println("\nAll Java assertions in the test suite passed (none failed)");
				
		
		}

		public static void main(String[] args) throws ParseException {
		testConstructor();
		testSetters();

	}

}
