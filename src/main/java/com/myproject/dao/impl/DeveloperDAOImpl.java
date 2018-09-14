package com.myproject.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.DeveloperDAO;
import com.myproject.entity.Developers;
import com.myproject.model.DeveloperInfo;
import com.myproject.model.PaginationResult;

// Transactional for Hibernate
@Transactional
public class DeveloperDAOImpl implements DeveloperDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// /Achtung! 3 odinakovih metoda findProduct
	@Override
	public Developers findDeveloper(String devName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Developers.class);
		crit.add(Restrictions.eq("devName", devName));
		return (Developers) crit.uniqueResult();
	}

	@Override
	public DeveloperInfo findDeveloperInfo(String devName) {
		Developers Developers = this.findDeveloper(devName);
		if (Developers == null) {
			return null;
		}
		return new DeveloperInfo(Developers.getDevName(),
				Developers.getDevCity(), Developers.getDevJob());
	}

	@Override
	public void save(DeveloperInfo DeveloperInfo) {
		String devName = DeveloperInfo.getDevName();

		Developers Developers = new Developers();
		//

		if (devName != null) {
			Developers = this.findDeveloper(devName);

		}
		if (Developers == null) {
			Developers = new Developers();
			boolean isNewDeveloper = true;

			Developers.setDevName(DeveloperInfo.getDevName());
			Developers.setDevCity(DeveloperInfo.getDevCity());
			Developers.setDevJob(DeveloperInfo.getDevJob());

			if (isNewDeveloper) {
				this.sessionFactory.getCurrentSession().persist(Developers);
			}

			this.sessionFactory.getCurrentSession().flush();
		}
	}

	@Override
	public PaginationResult<DeveloperInfo> queryDeveloper(int page,
			int maxResult, int maxNavigationPage, String likeName) {
		String sql = "Select new " + DeveloperInfo.class.getName() // !!Achtung!
																	// sdes
																	// .getName()
																	// prosto
																	// metod iz
																	// query---ne
																	// menat ego
																	// ima
				+ "(p.devName, p.devCity, p.devJob) " + " from "//
				+ Developers.class.getName() + " p ";
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		if (likeName != null && likeName.length() > 0) {
			query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
		}
		return new PaginationResult<DeveloperInfo>(query, page, maxResult,
				maxNavigationPage);
	}

	public PaginationResult<DeveloperInfo> queryDeveloperByCity(int page,
			int maxResult, int maxNavigationPage, String likeCity) {
		String sql = "Select new " + DeveloperInfo.class.getName() // !!Achtung!
																	// sdes
																	// .getName()
																	// prosto
																	// metod iz
																	// query---ne
																	// menat ego
																	// ima
				+ "(p.devName, p.devCity, p.devJob) " + " from "//
				+ Developers.class.getName() + " p ";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		if (likeCity != null && likeCity.length() > 0) {
			query.setParameter("likeName", "%" + likeCity.toLowerCase() + "%");
		}
		return new PaginationResult<DeveloperInfo>(query, page, maxResult,
				maxNavigationPage);
	}

	@Override
	public PaginationResult<DeveloperInfo> queryDeveloper(int page,
			int maxResult, int maxNavigationPage) {
		return queryDeveloper(page, maxResult, maxNavigationPage, null);
	}

}