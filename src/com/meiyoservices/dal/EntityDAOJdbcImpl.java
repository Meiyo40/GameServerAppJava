package com.meiyoservices.dal;

import java.util.List;

public interface EntityDAOJdbcImpl<T> {
	public void insert(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T selectById(int id);
	public T selectByName(String name);
	public List<T> selectAll();
}
