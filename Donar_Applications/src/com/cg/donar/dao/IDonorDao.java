package com.cg.donar.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.donar.bean.DonorBean;
import com.cg.donar.exception.DonorException;

public interface IDonorDao {
	public String addDonor(DonorBean donor) throws DonorException;
	public DonorBean viewDonorDetails(String donorId) throws DonorException, SQLException;
	public List retrieveAll() throws DonorException;

}
