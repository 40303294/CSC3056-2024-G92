/*
 * Class done by Lauren + chooiwen
 */

package src.tests;

import model.User;
import utils.TestUtils;

public class UserTest {
	
	
	public static void main(String[] args) {
		testUserConstructor();
	}
	
	
	public static void testUserConstructor() {
		/* OLD: manual testing
		User testUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		
		System.out.println(testUser);
		*/
		
		// Automated Testing
		
				// 1 - Setup
				String test_username = "mike";
				String test_password = "my_passw";
				String test_first_name = "Mike";
				String test_last_name = "Smith";
				String test_mobile_number = "07771234567";
				
				
				// 2 - Exercise, Run the object under test (Constructor)
				User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);
				
				
				// 3 - Verify (Assert)
				System.out.println("Starting the assertions of the test method: testUserConstructor");
				
				if (testUser.getUsername() == test_username)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getPassword() == test_password)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				// TODO 1 - Develop The three other test code blocks
				
				if (testUser.getFirst_name() == test_first_name)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getFirstName-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getFirstName-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getLast_name() == test_last_name)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getLastName-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getLastName-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				if (testUser.getMobile_number() == test_mobile_number)
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getMobileNumber-Passed" + TestUtils.TEXT_COLOR_RESET);
				else
					System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getMobileNumber-FAILED" + TestUtils.TEXT_COLOR_RESET);
				
				
				// Asserts
				
				// assert 1 == 2;
				assert testUser.getUsername() == test_username;
				assert testUser.getPassword() == test_password;
				assert testUser.getFirst_name() == test_first_name;
				assert testUser.getLast_name() == test_last_name;
				assert testUser.getMobile_number() == test_mobile_number;
				
				System.out.println("All Java assertions in the test suite passed (none failed)");

			}

}
