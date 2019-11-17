package com.myproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.AccountDAO;
import com.myproject.entity.Account;
import com.myproject.model.AccountInfo;

// Transactional for Hibernate
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account findAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Account.class);
		crit.add(Restrictions.eq("userName", userName));
		return (Account) crit.uniqueResult();
	}

	@Override
	public AccountInfo findAccountInfo(String userName) {
		Account account = this.findAccount(userName);
		if (account == null) {
			return null;
		}
		return new AccountInfo(account.getUserName(), account.getIsActive(),
				account.getPassword(), account.getUserRole());a!!
	}

	@Override
	public void save(AccountInfo accountInfo) {
		String userName = accountInfo.getUserName();

		Account account = new Account();
		if (userName != null) {
			account = this.findAccount(userName);
		}
		if (account == null) {
			boolean isNewAccount = true;
			account = new Account();

			account.setUserName(accountInfo.getUserName());
			account.setIsActive(true);
			account.setPassword(accountInfo.getPassword());
			account.setUserRole(accountInfo.getUserRole());

			// photo upload
			// if (employerInfo.getFileData() != null) {
			// byte[] image = employerInfo.getFileData().getBytes();
			// if (image != null && image.length > 0) {
			// employers.setImage(image);
			// }
			// }
			if (isNewAccount) {
				this.sessionFactory.getCurrentSession().persist(account);
			}

			this.sessionFactory.getCurrentSession().flush();
		}
	}
}
