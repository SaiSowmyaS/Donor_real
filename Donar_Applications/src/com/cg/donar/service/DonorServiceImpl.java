package com.cg.donar.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.donar.bean.DonorBean;
import com.cg.donar.dao.DonorDaoImpl;
import com.cg.donar.dao.IDonorDao;
import com.cg.donar.exception.DonorException;

public class DonorServiceImpl implements IDonorService {
	IDonorDao donordao=new DonorDaoImpl();

	@Override
	public String addDonor(DonorBean donor) throws DonorException {
		String donorSeq;
		donorSeq=donordao.addDonor(donor);
		return donorSeq;
	}

	@Override
	public DonorBean viewDonorDetails(String donorId) throws DonorException, SQLException {
		System.out.println(donorId);
		DonorBean donorBean=new DonorBean();
				donorBean=donordao.viewDonorDetails(donorId);
		//System.out.println(donorbean);
		return donorBean;
	}

	@Override
	public List retrieveAll() throws DonorException {
		// TODO Auto-generated method stub
		donordao=new DonorDaoImpl();
		List<DonorBean> donorList=null;
		donorList=donordao.retrieveAll();
		return donorList;
		
	}
	public boolean validateDonor(DonorBean bean) throws DonorException
	{
		List<String> validationErrors=new ArrayList<String>();
		if(!(isValidName(bean.getDonorName())))
		{
			validationErrors.add("\nDonor name should be Alphabets and minimum 3 characters long!\n");
		}
		if(!(isValidAddress(bean.getAddress())))
		{
			validationErrors.add("\n Address should be greater than 5 characters!\n");
		}
		if(!(isValidPhoneNumber(bean.getPhoneNumber())))
		{
			validationErrors.add("\nphone number should be in 10 digits");
		}
		if(!(isValidAmount(bean.getDonationAmount())))
		{
			validationErrors.add("\n Amount should be positive");
		}
		/*if(!(isValidId(bean.getDonorId())))
		{
			validationErrors.add("\nID should be in 4 numbers");
		}*/
		if(!validationErrors.isEmpty())
			return false;
			//throw new DonorException(validationErrors +"");
	
	return true;
	}

	/*private boolean isValidId(String donorId) {
		
		Pattern idPattern=Pattern.compile("[0-9]{1,4}");
		Matcher idMatcher=idPattern.matcher(donorId);
		if(idMatcher.matches())
			return true;
		else
		return false;
	}*/

	private boolean isValidAmount(double donationAmount) {
		
		return donationAmount > 0;
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
	}

	private boolean isValidAddress(String address) {
				
		return (address.length() > 5);
	}

	private boolean isValidName(String donorName) {
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(donorName);
		return nameMatcher.matches();
	}

}
