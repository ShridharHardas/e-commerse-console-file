package Product_Management;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Common.DBUtil;

public class ProductManagement {

	public void productManagementMain() throws SQLException {
		System.out.println("**************Welcome to Product Manaegement*****************");
		Scanner sc = new Scanner(System.in);
		Product product = new Product();
		boolean shallContinue = true;
		while (shallContinue) {
			System.out.println("What would you like to do today ?");
			System.out.println("1.Add Product");
			System.out.println("2.Update Product");
			System.out.println("3.Search Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Print Product");
			System.out.println("6.Exit\n");
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("---------------Add Product---------------");
				System.out.println("Enter Product Name :");
				product.productName = sc.next();
				System.out.println("Enter Product Quantity :");
				product.productQuantity = sc.nextInt();
				System.out.println("Entewr Product Price :");
				product.productPrice = sc.nextLong();
				String insertQuery="insert into Product(productName,productQuantity,productPrice) values('"+product.productName+"','"+product.productQuantity+"','"+product.productPrice+"')";
				DBUtil.executeQuery(insertQuery);
				System.out.println("Adding Product Successfully..!");
				
				break;
			case 2:
				System.out.println("-----------------Update Product-------------");
				System.out.println("Enter Product Name to Update :");
				String updateProduct = sc.next();
				String selectUpdateQuery="select * from product where productName='"+updateProduct+"'";
				ResultSet updateResultSet=DBUtil.executeSelectQuery(selectUpdateQuery);
				if(updateResultSet.next())
				{
					System.out.println("Enter Updated Product Name :");
					String updateProductName=sc.next();
					System.out.println("Enter Updated Product Quantity :");
					int updateProductQuantity=sc.nextInt();
					System.out.println("Enter Updated Product Price :");
					long updateProductPrice=sc.nextLong();
					String updateQuery="update product set productName='"+updateProductName+"',productQuantity='"+updateProductQuantity+"',productPrice='"+updateProductPrice+"' where productName='"+updateProduct+"'";
					DBUtil.executeQuery(updateQuery);
					System.out.println("Updated Product data successfully..!");
				
				}
				else {
					System.out.println("Product Not Found..!");
				}
				break;
			case 3:
				System.out.println("------------------Search Product-------------------");
				System.out.println("Enter Product Name to Search :");
				String searchProductName = sc.next();
				String searchProductQuery="select * from product where productName='"+searchProductName+"'";
				ResultSet searchResultSet=DBUtil.executeSelectQuery(searchProductQuery);
				while(searchResultSet.next())
				{
					System.out.println("Information of product :"+searchResultSet.getString(2)+","+searchResultSet.getInt(3)+","+searchResultSet.getDouble(4));
				}
				break;
			case 4:
				System.out.println("-----------------Delete Product--------------------");
				System.out.println("Enter Product Name to delete :");
				String deleteProductName = sc.next();
				String deleteQuery="delete from product where productName='"+deleteProductName+"'";
				DBUtil.executeQuery(deleteQuery);
				break;
			case 5:
				System.out.println("-------------------Print Product------------------");
				String printQuery="select * from product";
				ResultSet printResultSet=DBUtil.executeSelectQuery(printQuery);
				while(printResultSet.next())
				{
					System.out.println(printResultSet.getString(2)+","+printResultSet.getInt(3)+","+printResultSet.getDouble(4));
				}
				break;
			case 6:
				System.out.println("Exit,The Product Management Successfully..!");
				shallContinue = false;
			default:
				System.out.println("Please,Enter the valid choice :");
			}
		}
	}

	
}
