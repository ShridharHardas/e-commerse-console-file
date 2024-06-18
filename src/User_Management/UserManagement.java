package User_Management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Common.DBUtil;

public class UserManagement {

	public void UserManagementMain() throws  SQLException {
		System.out.println("**************Welcome to UserManagement*****************");
		User user = new User();
		boolean shallKeepRunning = true;
		Scanner sc = new Scanner(System.in);
		while (shallKeepRunning) {
			System.out.println("What would you like to do today ?");
			System.out.println("1.Add User");
			System.out.println("2.Update User");
			System.out.println("3.Search User");
			System.out.println("4.Delete User");
			System.out.println("5.Print User");
			System.out.println("6.Exit\n");
			System.out.println("Enter your decision :");
			int decision = sc.nextInt();
			switch (decision) {
			case 1:
				System.out.println("--------------Add User-----------------");
				System.out.println("Enter the First Name : ");
				user.firstName = sc.next();
				System.out.println("Enter the Last Name : ");
				user.lastName = sc.next();
				System.out.println("Enter the gender : ");
				user.gender = sc.next();
				System.out.println("Enter the age : ");
				user.age = sc.nextInt();
				System.out.println("Enter the Email : ");
				user.email = sc.next();
				System.out.println("Enter the password : ");
				user.password = sc.next();
				System.out.println("Enter the ConfirmPassword :");
				String confirmPassword = sc.next();
				if (user.password.contains(confirmPassword)) {
					System.out.println("Password and conifirmPassword Match..");
					System.out.println("User Addition Successfully...!");
					String query="insert into user(userFirstName, userLastName, userAge, userGender, userEmail ,userPassword ) values('"+user.firstName+"','"+user.lastName+"','"+user.age+"','"+user.gender+"','"+user.email+"','"+user.password+"')";
					DBUtil.executeQuery(query);
				} else {
					System.out.println("Password and conifirmPassword UnMatch..");
					System.out.println("User Addition UnSuccessfully...!");
				}
				break;
			case 2:
				System.out.println("-----------------Update User-----------------");
				System.out.println("Enter User Data to Update :");
				String updateUserData = sc.next();
						String query="select * from user where userFirstName='"+updateUserData+"'";
						ResultSet resultSet=DBUtil.executeSelectQuery(query);
						if(resultSet.next())
						{
						System.out.println("Enter the First Name : ");
						String updateFirstName = sc.next();
						System.out.println("Enter the Last Name : ");
						String updateLastName = sc.next();
						System.out.println("Enter the gender : ");
						String updateGender = sc.next();
						System.out.println("Enter the age : ");
						int updateAge = sc.nextInt();
						System.out.println("Enter the Email : ");
						String updateEmail = sc.next();
						System.out.println("Enter the password : ");
						String updatePassword = sc.next();
						System.out.println("Enter the ConfirmPassword :");
						String updateConfirmPassword = sc.next();
						if (updatePassword.contains(updateConfirmPassword)) {
							System.out.println("Password and confirmPassword Match ..!");
							System.out.println("Addition User Data Successfully..!");
							String updateQuery="update user set userFirstName='"+updateFirstName+"',userLastName='"+updateLastName+"',userAge='"+updateAge+"',userGender='"+updateGender+"',userEmail='"+updateEmail+"',userPassword='"+updatePassword+"' where userFirstName='"+updateUserData+"'";
							DBUtil.executeQuery(updateQuery);
						} else {
							System.out.println("Password and conifirmPassword UnMatch..");
							System.out.println("User Addition UnSuccessfully...!");
						}
					}
					else
						{
							System.out.println("User Data Not Found..!");
						}
				break;
			case 3:
				System.out.println("-----------------Search User-----------------");
				System.out.println("Enter User Data to Search :");
				String searchUserData = sc.next();
				String selectSearchQuery="select * from user where userFirstName='"+searchUserData+"'";
				ResultSet searchResulSet=DBUtil.executeSelectQuery(selectSearchQuery);
				while(searchResulSet.next())
				{
					System.out.println("Information of User:"+searchResulSet.getString(2)+","+searchResulSet.getString(3)+","+searchResulSet.getInt(4)+","+searchResulSet.getString(5)+","+searchResulSet.getString(6)+","+searchResulSet.getString(7));
				}
				break;
			case 4:
				System.out.println("----------------Delete User------------------");
				System.out.println("Enter User Data to Delete :");
				String deleteUserData = sc.next();
				String deletQuery="delete from user where userFirstName='"+deleteUserData+"'";
				DBUtil.executeQuery(deletQuery);
				break;
			case 5:
				System.out.println("---------------Print User------------------");
				String printQuery="select * from user";
				ResultSet printResultSet=DBUtil.executeSelectQuery(printQuery);
				while(printResultSet.next())
				{
					System.out.println(printResultSet.getString(2)+","+printResultSet.getString(3)+","+printResultSet.getInt(4)+","+printResultSet.getString(5)+","+printResultSet.getString(6)+","+printResultSet.getString(7));
				}
				break;
			case 6:
				System.out.println("Exit,The User Management Successfully..!");
				shallKeepRunning = false;
				break;
			default:
				System.out.println("Please,Enter the valid decision :");
			}
		}
	}

}
