package ECommerseManagement;

import java.io.IOException;
import java.util.Scanner;

import ProductManagement.ProductManagement;
import UserManagement.UserManagement;

public class ApplicationMain {
	public static void main(String[] args) throws IOException {
		System.out.println("************Welcome To ECommerse Management**********");
		Scanner sc=new Scanner(System.in);
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
				userManagement.userManagementMain();
			case 2:
				ProductManagement productManagement=new ProductManagement();
				productManagement.productManagementMain();
				break;
			case 3:
				System.out.println("Exit, The Application Successfully..!");
				shallRunning=false;
				break;
			default:
				System.out.println("Please,Enter the valid choice :");
			}
		}
		
	}

}
