package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
	List<String> userDataIntoFile=new ArrayList<>();
	public void userManagementMain() throws IOException
	{
		System.out.println("**************Welcome To User Management**************");
		loadUserDataFromFile();
		Scanner sc=new Scanner(System.in);
		User user=new User();
		boolean shallRunning=true;
		while(shallRunning)
		{
			System.out.println("What would you like to do today ?");
			System.out.println("1.Add User");
			System.out.println("2.Update User");
			System.out.println("3.Search User");
			System.out.println("4.Delete User");
			System.out.println("5.Print User");
			System.out.println("6.Exit");
			System.out.println("Enter your choice :");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("__________Add User__________");
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
				String confirmPassword=sc.next();
				if(user.password.contains(confirmPassword))
				{
					System.out.println("Password and confirmPassword Match ..!");
					System.out.println("Addition User Data Successfully..!");
				}
				else
				{
					System.out.println("Password and confirmPassword UnMatch ..!");
					System.out.println("Addition User Data Failed");
				}
				userDataIntoFile.add(user.firstName+","+user.lastName+","+user.age+","+user.email+","+user.gender+","+user.password);
				break;
			case 2:
				System.out.println("_________Update User__________");
				System.out.println("Enter User Name to Update :");
				String updateUser=sc.next();
				for(int i=0;i<userDataIntoFile.size();i++)
				{
					if(userDataIntoFile.get(i).contains(updateUser))
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
						String updateConfirmPassword=sc.next();
						if(updatePassword.contains(updateConfirmPassword))
						{
							System.out.println("Password and confirmPassword Match ..!");
							System.out.println("Addition User Data Successfully..!");
						}
						else
						{
							System.out.println("Password and confirmPassword UnMatch ..!");
							System.out.println("Addition User Data Failed");
						}
						userDataIntoFile.set(i, updateFirstName+","+updateLastName+","+updateAge+","+updateEmail+","+updateGender+","+updatePassword);
						
					}
				}
				break;
			case 3:
				System.out.println("___________Search User___________");
				System.out.println("Enter User Data to search :");
				String searchUser=sc.next();
				for(int i=0;i<userDataIntoFile.size();i++)
				{
					if(userDataIntoFile.get(i).contains(searchUser))
					{
						System.out.println(userDataIntoFile.get(i));
					}
				}
				break;
			case 4:
				System.out.println("_______________Delete User__________");
				System.out.println("Enter User Data to Delete :");
				String deleteUser=sc.next();
				for(int i=0;i<userDataIntoFile.size();i++)
				{
					if(userDataIntoFile.get(i).contains(deleteUser))
					{
						userDataIntoFile.remove(i);
					}
				}
			break;
			case 5:
				System.out.println("______________Print User_____________");
				for(String printUser:userDataIntoFile)
				{
					System.out.println(printUser);
				}
				break;
			case 6:
				System.out.println("Exit,The User Management Successfully...!");
				writeUserDataIntoFile();
				shallRunning=false;
				break;
			default:
				System.out.println("Please,Enter the valid choice :");
				
			}
		}
				
	}
	public void loadUserDataFromFile() throws IOException
	{
		File fileRead=new File("C:\\Users\\Shridhar\\eclipse-workspace\\ECommerse_ArrayList\\src\\UserManagement\\User.txt");
		FileReader fileReader=new FileReader(fileRead);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String line="";
		while((line=bufferedReader.readLine())!=null)
		{
			userDataIntoFile.add(line);
		}
		bufferedReader.close();
		
	}
	public void writeUserDataIntoFile() throws IOException
	{
		File file=new File("C:\\Users\\Shridhar\\eclipse-workspace\\ECommerse_ArrayList\\src\\UserManagement\\User.txt");
		FileWriter fileWriter=new FileWriter(file,false);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		for(String writeUserData:userDataIntoFile)
		{
			bufferedWriter.write(writeUserData);
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	

}
