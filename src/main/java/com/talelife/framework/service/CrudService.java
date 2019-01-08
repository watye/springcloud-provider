package com.talelife.framework.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.talelife.framework.entity.BaseEntity;

public interface CrudService<T extends BaseEntity> {
	public List<T> findList(T paramT);

	public PageInfo<T> findListPage(T paramT, int pageNumber, int pageSize);

	public int getCount(T paramT);

	public T getById(Long paramLong);

	public List<T> getByIds(List<Long> ids);

	public T get(T paramT);

	public boolean save(T paramT);

	public boolean updateById(T paramT);

	public boolean updateByIds(T paramT, Long[] paramArrayOfLong);

	public boolean deleteById(Long paramLong);

	public boolean delete(T paramT);

	public boolean deleteByIds(List<Long> ids);
}
