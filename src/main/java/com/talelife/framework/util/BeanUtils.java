package com.talelife.framework.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.TypeFactory;

/**
 * Bean工具类
 * @author lwy
 *
 */
public final class BeanUtils {
	private static MapperFacade MAPPER_FACADE = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	/**
	 * 对象类型转换
	 * @param sourceObject 源对象
	 * @param targetClass 目标类型
	 * @return 目标类型的对象
	 */
	public static <E, T> T map(E sourceObject, Class<T> targetClass) {
		return MAPPER_FACADE.map(sourceObject, targetClass);
	}
	
	/**
	 * 集合的对象类型转换
	 * @param sourceObject 源对象
	 * @param sourceClass 源类型
	 * @param targetClass 目标类型
	 * @return 目标类型的对象
	 */
	public static <E, T> List<T> mapAsList(Iterable<E> sourceObject, Class<E> sourceClass, Class<T> targetClass) {
		if(Objects.isNull(sourceObject)) {
			return new ArrayList<T>();
		}
		return MAPPER_FACADE.mapAsList(sourceObject, TypeFactory.valueOf(sourceClass), TypeFactory.valueOf(targetClass));
	}
}
