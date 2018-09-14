package com.myproject.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.engine.spi.Mapping;

import com.myproject.dao.KanbanDAO;
import com.myproject.entity.Kanban;
import com.myproject.model.DeveloperInfo;
import com.myproject.model.KanbanInfo;
import com.myproject.model.PaginationResult;

// Transactional for Hibernate
@Transactional
public class KanbanDAOImpl implements KanbanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@SuppressWarnings("unchecked")
	@Override
	public    ArrayList<Kanban> findKanbanListByUserName(String userName) {
		ArrayList<Kanban> resultList = new ArrayList<Kanban>();
		
		 Session session = sessionFactory.getCurrentSession();
		 Criteria cr = session.createCriteria(Kanban.class);
		 cr.add(Restrictions.eq("userName", userName));
		 cr.list();
	     resultList.addAll(  cr.list());
     
        System.out.println(" ! resultList.isEmpty(): "+resultList.isEmpty());
        for (Iterator it = resultList.iterator(); it.hasNext();) {
        	System.out.println(it.next());
        }
        
        return resultList;
	}
	
	
	@Override
	public Kanban findKanban(String userName, String jobName) { //here use Criteria API
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Kanban.class);
		crit.add(Restrictions.eq("userName", userName));
		crit.add(Restrictions.eq("jobName", jobName)).setMaxResults(1).uniqueResult();
		return (Kanban) crit.uniqueResult();
	}
	
	@Override
	public KanbanInfo findKanbanInfo(String userName, String jobName) {
		Kanban kanban = this.findKanban(userName, jobName);
		if (kanban == null) {
			return null;
		}
		return new KanbanInfo( kanban.getId(),kanban.getUserName(),
				kanban.getJobName(),  kanban.getCVDate(),
				kanban.getInterviewDate(),
				kanban.getJobOfferDate(),kanban.getIsJobOffer());
	}

	@Override
	public void save(KanbanInfo kanbanInfo) {
	
		String userName = kanbanInfo.getUserName();
		String jobName = kanbanInfo.getJobName();
		boolean isNew=false;
		Kanban kanban = null;
	 if (userName != null && jobName != null) {
		 kanban = this.findKanban(userName, jobName);
		 }
		 if (kanban == null) {
			 isNew = true;
			 kanban = new Kanban();
		 }
		kanban.setUserName(userName);
		kanban.setJobName(jobName);
		kanban.setCVDate(kanbanInfo.getCVDate());	
		kanban.setInterviewDate(kanbanInfo.getInterviewDate());	
		kanban.setJobOfferDate(kanbanInfo.getJobOfferDate());
		kanban.setIsJobOffer(kanbanInfo.getIsJobOffer());
		
		// photo upload
		// if (employerInfo.getFilekanbanData() != null) {
		// byte[] image = employerInfo.getFileData().getBytes();
		// if (image != null && image.length > 0) {
		// employers.setImage(image);
		// }
		// }
				this.sessionFactory.getCurrentSession().persist(kanban);
			this.sessionFactory.getCurrentSession().flush();
		}
			
	public  void remove(String userName, String jobName) {  //IPA
		Session session = sessionFactory.getCurrentSession();
		Kanban kanban = this.findKanban( userName,  jobName);
		System.out.println("kanban.getId(): " + kanban.getId());
		Object persistentInstance = session.load(Kanban.class, kanban.getId());
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		}
		System.out.println("!!!!!!!!!");
		this.sessionFactory.getCurrentSession().flush();
		}
//__________________________________			
	@PersistenceContext
    private EntityManager em;

	 final static String qlString = "select id, user_name, job_name, cv_date,"
	 		+ " interview_date, joboffer_date, is_joboffer version from kanban ";
	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<Kanban> getAll(String userName) { ///JPA , em muss andere sein:(
		javax.persistence.Query query = em.createNativeQuery(qlString, Kanban.class);
        query.setParameter("userName", userName);
        return ((java.util.List<Kanban>) query.getResultList());
	}
	
}