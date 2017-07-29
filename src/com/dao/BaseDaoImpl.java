package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(object);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(object);
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(object);
	}


	@Override
	public Object ReadSingle(final String targetName,final String propertyName,final Object value) {
		// TODO Auto-generated method stub
		return (Object) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from "+targetName+" as "+targetName+" where "+targetName+"." + propertyName + "=:value";
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				return query.uniqueResult();
			}
		});

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> ReadByProperty(final String targetName, final String propertyName,
			final Object value) {
		// TODO Auto-generated method stub
		return (List<Object>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			/*doInHibernate()。session的创建和销毁，一切都在程序内部完成。*/
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from "+targetName+" as "+targetName+" where "+targetName+"." + propertyName + "=:value";
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> ReadAll(String targetName) {
		// TODO Auto-generated method stub
		String hql = "from "+targetName;
		return getHibernateTemplate().find(hql);
	}

	@Override
	public List<Object> ReadByPropertyList(final String targetName,final String propertyName,final Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer ReadCount(String targetName) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException{
				String hql = "select count(*) from "+targetName;
				return ((Number)session.createQuery(hql).iterate().next()).intValue();
			}
		});
	}
	
	

	@Override
	public Integer ReadCountByProperty(final String targetName,final String propertyName,final Object value) {
		// TODO Auto-generated method stub
		return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException{
				String hql = "select count(*) from "+targetName+" as "+targetName+" where "+targetName+"."+propertyName+"=:value";
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				return ((Number)query.iterate().next()).intValue();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> ReadLimitedByOrder(final String targetName,final String propertyName,final int num,final String order) {
		// TODO Auto-generated method stub
		return (List<Object>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException{
				String hql = "from "+targetName+" as "+targetName+" order by "+targetName+"."+propertyName+" "+order;
				Query query = session.createQuery(hql);
				query.setMaxResults(num);
				return query.list();
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> ReadByPropertyAndLimitedByOrder(final String targetName,final String readpropertyName,final Object readvalue,
		final String orderpropertyName,final int num,final String order) {
		// TODO Auto-generated method stub
		return (List<Object>) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from "+targetName+" as "+targetName+" where "+targetName+"."+readpropertyName+"=:value"+" order by "+targetName+" "+order;
				Query query = session.createQuery(hql);
				query.setParameter("value", readvalue);
				query.setMaxResults(num);
				return query.list();
			}

		});
	}

}
