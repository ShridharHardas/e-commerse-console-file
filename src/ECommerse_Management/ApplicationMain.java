package ECommerse_Management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Product_Management.ProductManagement;
import User_Management.UserManagement;

public class ApplicationMain {
	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("***************Welcome to ECommerse Management**********************");
		Scanner sc=new Scanner(System.in );
		boolean shallRunning=true;
		while(shallRunning)
		{
			System.out.println("What would you like to do today ?");
			System.out.println("1.User Management");
			System.out.println("2.Product Management");
			System.out.println("3.Exit ");
			System.out.println("Enter your choice :");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				UserManagement userManagement=new UserManagement();
				userManagement.UserManagementMain();
			break;
			case 2:
				ProductManagement productManagement=new ProductManagement();
				productManagement.productManagementMain();
			break;
			case 3:
				System.out.println("Exit,The Appliaction Successfully..!");
				shallRunning=false;
			break;
			default:
				System.out.println("Please,EEnter the valid choice :");
			}
		}
	}

}
