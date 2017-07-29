package com.service;

import java.util.List;

public interface BaseService {
	
	public void save(Object object);
	
	public void update(Object object);
	
	public void delete(Object object);
	
	public Object ReadByID(String targetName, int id);
	
	@SuppressWarnings("rawtypes")
	public List ReadAll(String targetName);
	
	@SuppressWarnings("rawtypes")
	public List ReadByProperty(String targetName, String propertyName, Object propertyValue);
	
	public Object ReadSingle(String targetName, String propertyName, Object propertyValue);
	
	@SuppressWarnings("rawtypes")
	public List ReadLimitedByOrder(String targetName, String propertyName, int num, String order);
	
	public int ReadCount(String targetName);
	
	public int ReadCountByProperty(String targetName, String propertyName, Object value);
	
	@SuppressWarnings("rawtypes")
	public List ReadbyPropertyAndLimitedByOrder(final String targetName,
			final String redpropertyName, final Object readvalue, final String orderpropertyName,
			final int num, final String order);
}
