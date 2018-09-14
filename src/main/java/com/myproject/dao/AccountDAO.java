package com.myproject.dao;

import com.myproject.entity.Account;
import com.myproject.model.AccountInfo;

public interface AccountDAO {

	public Account findAccount(String userName);

	public void save(AccountInfo accountInfo);

	AccountInfo findAccountInfo(String userName);

}