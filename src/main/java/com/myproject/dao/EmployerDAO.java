package com.myproject.dao;

import com.myproject.entity.Employers;
import com.myproject.model.EmployerInfo;
import com.myproject.model.PaginationResult;

public interface EmployerDAO {

	public Employers findEmployer(String emplName);

	public EmployerInfo findEmployerInfo(String emplName);

	public PaginationResult<EmployerInfo> queryEmployer(int page,
			int maxResult, int maxNavigationPage);

	public PaginationResult<EmployerInfo> queryEmployer(int page,
			int maxResult, int maxNavigationPage, String likeName);

	public PaginationResult<EmployerInfo> queryEmployerByCity(int page,
			int maxResult, int maxNavigationPage, String likeCity);

	public void save(EmployerInfo employerInfo);

}