package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import util.HibernateUtil;

public class GenericDAO<T> {
	
	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	public void save(T entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;	
		}
		finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query  = session.createCriteria(classe);
			List<T> result = query.list();
			return result;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria query  = session.createCriteria(classe);
			query.add(Restrictions.idEq(id));
			T result = (T) query.uniqueResult();
			return result;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void remove(T entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;	
		}
		finally {
			session.close();
		}
	}
	
	public void update(T entity){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;	
		}
		finally {
			session.close();
		}
	}
}
