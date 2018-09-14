package com.myproject.dao;

import com.myproject.entity.Developers;
import com.myproject.model.DeveloperInfo;
import com.myproject.model.PaginationResult;

public interface DeveloperDAO {

	public Developers findDeveloper(String devName);

	public DeveloperInfo findDeveloperInfo(String devName);

	public PaginationResult<DeveloperInfo> queryDeveloper(int page,
			int maxResult, int maxNavigationPage);

	// public PaginationResult<DeveloperInfo> queryEmployerByCity(int page, int
	// maxResult,
	// int maxNavigationPage, String likeCity);

	public void save(DeveloperInfo DeveloperInfo);

	PaginationResult<DeveloperInfo> queryDeveloper(int page, int maxResult,
			int maxNavigationPage, String likeName);

	public PaginationResult<DeveloperInfo> queryDeveloperByCity(int page,
			int maxResult, int maxNavigationPage, String likeCity);

}