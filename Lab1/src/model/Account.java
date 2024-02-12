/*
 * This java class was done by Chooi Wen
 */


package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import app.SimpleBankingApp;

public class Account {
	String account_number;
	String username_of_account_holder;
	String account_type;
	LocalDateTime account_opening_date;
	
	public String getAccount_number() {
		return account_number;
	}
	
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	public String getUsername_of_account_holder() {
		return username_of_account_holder;
	}
	
	public void setUsername_of_account_holder(String username_of_account_holder) {
		this.username_of_account_holder = username_of_account_holder;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	
	public LocalDateTime getAccount_opening_date() {
		return account_opening_date;
	}
	
	public void setAccount_opening_date(LocalDateTime account_opening_date) {
		this.account_opening_date = account_opening_date;
	}
	
	public String getFormattedOpeningDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		return account_opening_date.format(formatter);
	}

	public Account(String account_number, String username_of_account_holder, String account_type,
			LocalDateTime account_opening_date) {
		super();
		this.account_number = account_number;
		this.username_of_account_holder = username_of_account_holder;
		this.account_type = account_type;
		this.account_opening_date = account_opening_date;
	}
	
	public String toString() {
		return String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				account_number, username_of_account_holder, account_type, "("+ getFormattedOpeningDate() +")", 
				SimpleBankingApp.getBalance(account_number));
	}

}
