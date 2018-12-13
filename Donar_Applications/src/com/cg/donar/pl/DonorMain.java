package com.cg.donar.pl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.donar.bean.DonorBean;
import com.cg.donar.exception.DonorException;
import com.cg.donar.service.DonorServiceImpl;
import com.cg.donar.service.IDonorService;

public class DonorMain {
	static Scanner sc=new Scanner(System.in);
	static IDonorService donorService=null;
	static DonorServiceImpl donorServiceImpl=null;

	public static void main(String[] args) {
		 
		 DonorBean donorBean=null;
		 String donorId=null;
		 int option=0;
		 while(true)
		 {
			 System.out.println();
			 System.out.println();
			 System.out.println("ICARE CAPGEMINI TRUST");
			 System.out.println("________________________________");
			 System.out.println("1.Add Donor");
			 System.out.println("2.View Donor");
			 System.out.println("3.Retrieve Donor");
			 System.out.println("4.Exit");
			 System.out.println("______________________________");
			 System.out.println("select the option");
			 try 
			 {
				option=sc.nextInt();
				switch(option)
				{
				case 1:
					while(donorBean==null)
					{
						
						donorBean=populateDonorBean();
					}
					try
					{
						donorService=new DonorServiceImpl();
						donorId=donorService.addDonor(donorBean);
						System.out.println("Donor details has been successfully registered");
						System.out.println("Donator id is :"+donorId);
					}
					catch(DonorException donorException)
					{
						System.err.println("ERROR :"+donorException.getMessage());
						donorException.printStackTrace();
					}
					finally
					{
						donorId=null;
						donorService=null;
						donorBean=null;
					}
					break;
				case 2:
					System.out.println("enter donor_id");
					donorId=sc.next();
					donorService=new DonorServiceImpl();
					donorBean=donorService.viewDonorDetails(donorId);
					System.out.println(donorBean);
					
					break;
				case 3:
					
					donorService = new DonorServiceImpl();
					try {
						List<DonorBean> donorList = new ArrayList<DonorBean>();
						donorList = donorService.retrieveAll();

						if (donorList != null) {
							Iterator<DonorBean> i = donorList.iterator();
							while (i.hasNext()) {
								System.out.println(i.next());
							}
						} else {
							System.out
									.println("Nobody has made a donation, yet.");
						}

					}

					catch (DonorException e) {

						e.printStackTrace();
					}

					break;

				case 4:
					System.exit(0);
						
					break;
				default:
					System.out.println("Try Again!!!!!!!");
					break;
						
				}
			 }
			 catch(Exception e)
			 {
				e.printStackTrace();
			 }
			 
		 }
		
		

	}

	private static DonorBean populateDonorBean() {
		DonorBean donorBean=new DonorBean();
		System.out.println("Enter details");
		System.out.println("Enter the donor name:");
		donorBean.setDonorName(sc.next());
		System.out.println("Enter the Donor Contact");
		donorBean.setPhoneNumber(sc.next());
		System.out.println("Enter the donor Address");
		donorBean.setAddress(sc.next());
		System.out.println("Enter the donor amount");
		try
		{
		donorBean.setDonationAmount(sc.nextFloat());
		}
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.err.println("please enter the numeric value for donation amount,try again");
			ime.printStackTrace();
		}
		donorServiceImpl=new DonorServiceImpl();
		try
		{
		if(donorServiceImpl.validateDonor(donorBean))
		return donorBean;
		}
		catch(DonorException donorException)
		{
			System.out.println("Invalid data");
			System.err.println(donorException.getMessage()+"\n Try Again...");
			donorException.printStackTrace();
			System.exit(0);
		}
		return null;
	}

}
