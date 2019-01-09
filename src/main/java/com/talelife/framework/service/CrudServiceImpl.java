package com.talelife.framework.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.talelife.framework.entity.BaseEntity;
import com.talelife.framework.mapper.CrudMapper;

public abstract class CrudServiceImpl<T extends BaseEntity> {
	public CrudServiceImpl() {
	}

	public abstract CrudMapper<T> getDao();

	public List<T> findList(T entity) {
		return getDao().findList(entity);
	}

	public PageInfo<T> findListPage(T entity, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<T> page = new PageInfo<T>(getDao().findList(entity));
		return page;
	}

	public int getCount(T entity) {
		return getDao().getCount(entity);
	}

	public T getById(Long id) {
		return (T) getDao().getById(id);
	}

	public List<T> getByIds(List<Long> ids) {
		return getDao().getByIds(ids);
	}

	public T get(T entity) {
		return (T) getDao().get(entity);
	}

	public boolean save(T entity) {
		int rst = getDao().save(entity);
		return rst > 0;
	}

	public boolean updateById(T entity) {
		int rst = getDao().updateById(entity);
		return rst > 0;
	}

	public boolean updateByIds(T entity, Long[] ids) {
		int rst = getDao().updateByIds(entity, ids);
		return rst > 0;
	}

	public boolean deleteById(Long id) {
		int rst = getDao().deleteById(id);
		return rst > 0;
	}

	public boolean delete(T entity) {
		int rst = getDao().delete(entity);
		return rst > 0;
	}

	public boolean deleteByIds(List<Long> ids) {
		int rst = getDao().deleteByIds(ids);
		return rst > 0;
	}

	public boolean deleteByListId(List<Long> id) {
		int rst = getDao().deleteByListId(id);
		return rst > 0;
	}
}
