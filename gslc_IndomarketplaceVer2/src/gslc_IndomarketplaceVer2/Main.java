package gslc_IndomarketplaceVer2;

import java.util.Scanner;
import java.util.Vector;

import data.Customer;
import data.Seller;
import data.User;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Vector<User> listUser = new Vector<>();
	
	public Main() {
		int choice = 0;
		
		do {
			System.out.println("------");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.println("4. View");
			System.out.print(">> ");
			
			try {
				choice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid input!");
				sc.nextLine();
				continue;
			}
			
			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				System.out.println("Closing program...");
				break;
			case 4:
				view();
				break;
			default:
				System.out.println("Default output");
				break;
			}
			
		} while (choice != 3);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public static void login() {
		String username, password;
		
		do {
			System.out.print("Username: ");
			username = sc.nextLine();
		} while (username.isBlank());
		do {
			System.out.print("Password: ");
			password = sc.nextLine();
		} while (password.isBlank());
	}
	
	public static void register() {
		String type, username, password;
		
		do {
			System.out.print("Apakah anda mendaftar sebagai seller atau customer? ");
			type = sc.nextLine();
		} while (!type.equalsIgnoreCase("seller") && !type.equalsIgnoreCase("customer"));
		
		if(type.equalsIgnoreCase("customer")) {
			String gender;
			
			do {
				System.out.print("Username anda: ");
				username = sc.nextLine();
			} while (username.isBlank());
			do {
				System.out.print("Jenis kelamin anda (Pria | Wanita): ");
				gender = sc.nextLine();
			} while (!gender.equals("Wanita") && !gender.equals("Pria"));
			do {
				System.out.print("Password anda: ");
				password = sc.nextLine();
			} while (password.isBlank());
			
			listUser.add(new Customer(username, password, type, gender));
		}
		else {
			String namaToko, jenisToko, descToko;
			
			do {
				System.out.print("Username anda: ");
				username = sc.nextLine();
			} while (username.isBlank());
			do {
				System.out.print("Nama toko anda: ");
				namaToko = sc.nextLine();
			} while (namaToko.isBlank());
			do {
				System.out.print("Password anda: ");
				password = sc.nextLine();
			} while (password.isBlank());
			do {
				System.out.print("Jenis toko anda (Elektronik | Fashion | Makanan & Minuman): ");
				jenisToko = sc.nextLine();
			} while (!jenisToko.equalsIgnoreCase("Elektronik") && !jenisToko.equalsIgnoreCase("Fashion") && !jenisToko.equalsIgnoreCase("Makanan & Minuman"));
			do {
				System.out.print("Deskripsi toko anda: ");
				descToko = sc.nextLine();
			} while (descToko.isBlank());
			
			listUser.add(new Seller(username, password, type, namaToko, jenisToko, descToko));
		}
	}
	
	public static void view() {
		for (User curr : listUser) {
			if(curr instanceof Seller) {
				Seller currSeller = (Seller) curr;
				System.out.println(currSeller.getType() + " " + currSeller.getNamaToko() + " " + currSeller.getJenisToko() + " " + currSeller.getDescToko());
			}
			else {
				Customer currCust = (Customer) curr;
				System.out.println(currCust.getType() + " " + currCust.getUsername() + " " + currCust.getGender());
			}
		}
	}
}
