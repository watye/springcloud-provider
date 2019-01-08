package com.talelife.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CrudMapper<T>{
	public T getById(Long paramLong);

	public List<T> getByIds(@Param("ids") List<Long> ids);

	public T get(T paramT);

	public List<T> findAllList();

	public List<T> findList(T paramT);

	public int getCount(T paramT);

	public int save(T paramT);

	public int updateById(T paramT);

	public int updateByIds(@Param("entity") T paramT, @Param("ids") Long[] paramArrayOfLong);

	public int deleteById(Long paramLong);

	public int delete(T paramT);

	public int deleteByIds(@Param("array")List<Long> ids);

	public int deleteByListId(List<Long> paramList);
}
