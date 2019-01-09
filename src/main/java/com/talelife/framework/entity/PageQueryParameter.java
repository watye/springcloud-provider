package com.talelife.framework.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 分页查询对象
 * @author lwy
 */
public class PageQueryParameter<T> implements Serializable{
	
	private static final long serialVersionUID = 5456745700969377593L;
	/**
	 * 当前页
	 */
	@NotNull(message="页码不能为空")
    private Integer pageNum;
    /**
     * 每页的数量
     */
	@NotNull(message="分页数不能为空")
    private Integer pageSize;
    /**
     * 查询条件
     */
    private T query;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public T getQuery() {
		return query;
	}
	public void setQuery(T query) {
		this.query = query;
	}
}
