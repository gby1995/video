package com.dao;

import java.util.List;

public interface BaseDao {
	public void save(Object object);
	
	public void update(Object object);
	
	public void delete(Object object);
	
	public Object ReadSingle(String targetName, String propertyName, Object propertyValue);
	
	public List<Object> ReadByProperty(String targetName, String propertyName, Object propertyValue);
	
	public List<Object> ReadAll(String targetName);
	
	public List<Object> ReadByPropertyList(String targetName, String propertyName, Object propertyValue);
	
	public Integer ReadCount(String targetName);
	
	public Integer ReadCountByProperty(final String targetName, String propertyName, Object value);
	
	public List<Object> ReadLimitedByOrder(String targetName, String propertyName, int num, String order);
	
	public List<Object> ReadByPropertyAndLimitedByOrder(final String targetName, final String readpropertyName,
			final Object readvalue, final String orderpropertyName, final int num, final String order);
}
