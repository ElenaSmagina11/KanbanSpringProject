package com.myproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.EmployerDAO;
import com.myproject.entity.Employers;
import com.myproject.model.EmployerInfo;
import com.myproject.model.PaginationResult;

// Transactional for Hibernate
@Transactional
public class EmployerDAOImpl implements EmployerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employers findEmployer(String emplName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Employers.class);
		crit.add(Restrictions.eq("emplName", emplName));
		return (Employers) crit.uniqueResult();
	}

	@Override
	public EmployerInfo findEmployerInfo(String emplName) {
		Employers employers = this.findEmployer(emplName);
		if (employers == null) {
			return null;
		}
		return new EmployerInfo(employers.getEmplName(),
				employers.getEmplCity(), employers.getEmplVacancy());
	}

	@Override
	public void save(EmployerInfo employerInfo) {
		String emplName = employerInfo.getEmplName();
		Employers employers = new Employers();

		if (emplName != null) {
			employers = this.findEmployer(emplName);

		}
		if (employers == null) {
			employers = new Employers();
			boolean isNewEmployer = true;
			employers.setEmplName(employerInfo.getEmplName());
			employers.setEmplCity(employerInfo.getEmplCity());
			employers.setEmplVacancy(employerInfo.getEmplVacancy());

			if (isNewEmployer) {
				this.sessionFactory.getCurrentSession().persist(employers);
			}

			this.sessionFactory.getCurrentSession().flush();
		}
	}

	@Override
	public PaginationResult<EmployerInfo> queryEmployer(int page,
			int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + EmployerInfo.class.getName() // !!Achtung!
																	// sdes
																	// .getName()
																	// prosto
																	// metod iz
																	// query---ne
																	// menat ego
																	// ima
				+ "(p.emplName, p.emplCity, p.emplVacancy) " + " from "//
				+ Employers.class.getName() + " p ";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		if (likeName != null && likeName.length() > 0) {
			query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
		}
		return new PaginationResult<EmployerInfo>(query, page, maxResult,
				maxNavigationPage);
	}

	public PaginationResult<EmployerInfo> queryEmployerByCity(int page,
			int maxResult, int maxNavigationPage, String likeCity) {
		String sql = "Select new " + EmployerInfo.class.getName() // !!Achtung!
																	// sdes
																	// .getName()
																	// prosto
																	// metod iz
																	// query---ne
																	// menat ego
																	// ima
				+ "(p.emplName, p.emplCity, p.emplVacancy) " + " from "//
				+ Employers.class.getName() + " p ";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		if (likeCity != null && likeCity.length() > 0) {
			query.setParameter("likeName", "%" + likeCity.toLowerCase() + "%");
		}
		return new PaginationResult<EmployerInfo>(query, page, maxResult,
				maxNavigationPage);
	}

	@Override
	public PaginationResult<EmployerInfo> queryEmployer(int page,
			int maxResult, int maxNavigationPage) {
		return queryEmployer(page, maxResult, maxNavigationPage, null);
	}

}