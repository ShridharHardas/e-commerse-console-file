package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
	List<String> productDataIntoFile=new ArrayList<>();
	public void productManagementMain() throws IOException
	{
		System.out.println("***************Welcome To Product Management*************");
		loadProductDataFromFile();
		Scanner sc=new Scanner(System.in);
		Product product=new Product();
		boolean shallRunning=true;
		while(shallRunning)
		{
			System.out.println("What would you like to do today ?");
			System.out.println("1.Add Product");
			System.out.println("2.Update Product");
			System.out.println("3.Search Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Print Product");
			System.out.println("6.Exit\n");
			System.out.println("Enter Your Choice :");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("_________Add Product_______");
				System.out.println("Enter Product Name :");
				product.productName=sc.next();
				System.out.println("Enter Product Quantity :");
				product.productQuantity=sc.nextInt();
				System.out.println("Enter Product Price :");
				product.productPrice=sc.nextLong();
				productDataIntoFile.add(product.productName+","+product.productQuantity+","+product.productPrice);
				break;
			case 2:
				System.out.println("_________Update Product______");
				System.out.println("Enter Product Name to Update :");
				String updateProductData=sc.next();
				for(int i=0;i<productDataIntoFile.size();i++)
				{
					if(productDataIntoFile.get(i).contains(updateProductData))
					{
						System.out.println("Enter Product Name :");
						String updateProductName=sc.next();
						System.out.println("Enter Product Qunatity :");
						int updateProductQunatity=sc.nextInt();
						System.out.println("Enter Product Price :");
						long updateProductPrice=sc.nextLong();
						productDataIntoFile.set(i, updateProductName+","+updateProductQunatity+","+updateProductPrice);
					}
				}
				break;
			case 3:
				System.out.println("__________Search Product______");
				System.out.println("Enter Product Name to Search :");
				String searchProductData=sc.next();
				for(int i=0;i<productDataIntoFile.size();i++)
				{
					if(productDataIntoFile.get(i).contains(searchProductData))
					{
						System.out.println(productDataIntoFile.get(i));
					}
				}
				break;
			case 4:
				System.out.println("________Delete Product________");
				System.out.println("Enter Product  Name to Delete :");
				String deleteProductData=sc.next();
				for(int i=0;i<productDataIntoFile.size();i++)
				{
					if(productDataIntoFile.get(i).contains(deleteProductData))
					{
						productDataIntoFile.remove(i);
					}
				}
			break;
			case 5:
				System.out.println("_________Print Product_______");
				for(String obj:productDataIntoFile)
				{
					System.out.println(obj);
				}
			break;
			case 6:
				System.out.println("Exit,The Product Management Successfully..!");
				writeProductListDataIntoFile();
				shallRunning=false;
			break;
			default:
				System.out.println("Please,Enter the valid choice :");
			}
		}
		
	}
	public void loadProductDataFromFile() throws IOException
	{
		File fileRead=new File("C:\\Users\\Shridhar\\eclipse-workspace\\ECommerse_ArrayList\\src\\ProductManagement\\Product.txt");
		FileReader fileReader=new FileReader(fileRead);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String line="";
		if((line=bufferedReader.readLine())!=null)
		{
			productDataIntoFile.add(line);
		}
		bufferedReader.close();
		
	}
	public void writeProductListDataIntoFile() throws IOException
	{
		File fileWrite=new File("C:\\Users\\Shridhar\\eclipse-workspace\\ECommerse_ArrayList\\src\\ProductManagement\\Product.txt");
		FileWriter fileWriter=new FileWriter(fileWrite,false);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		for(String Product:productDataIntoFile)
		{
			bufferedWriter.write(Product);
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
}
