package com.xjx.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import com.xjx.core.base.Record;
import com.xjx.util.BeanUtils;

public abstract class BasicDaoImpl<T extends Record> implements BasicMapper<T> {
	@Autowired
	private BasicMapper basicMapper;
	
	/**
	 * @fields sqlNamespace SqlMapping命名空间
	 */
	private String sqlNamespace = getDefaultSqlNamespace();

	/**
	 * 获取泛型类型的实体对象类全名
	 * 
	 * @author
	 * @return
	 * @date 2014年3月3日下午6:17:46
	 */
	protected String getDefaultSqlNamespace() {
		Class<?> genericClass = BeanUtils.getGenericClass(this.getClass());
		return genericClass == null ? null : genericClass.getName();
	}

}
