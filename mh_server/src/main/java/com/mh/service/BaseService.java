package com.mh.service;

import com.mh.entity.BaseEntity;
import com.sun.javafx.css.converters.BooleanConverter;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/7/25.
 */
public abstract class BaseService<T extends BaseEntity> {
    /**
     * 日志记录实例
     */
    protected final transient Logger logger = LoggerFactory.getLogger(getClass());

    static {
        // date
        ConvertUtils.register(new DateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlTimeConverter(null), Time.class);
        ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
        // number
        ConvertUtils.register(new ShortConverter(null), Short.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new FloatConverter(null), Float.class);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
    }

    @Resource
    protected SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获取相关的Dao
     *
     * @return
     */
    protected abstract PagingAndSortingRepository<T, Long> getDao();

    @Transactional(readOnly = false)
    public <S extends T> S save(S entity) {
        return getDao().save(entity);
    }


    @Transactional(readOnly = false)
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        return getDao().save(entities);
    }

    public T findOne(Long id) {
        return getDao().findOne(id);
    }

    public Iterable<T> findAll() {
        return getDao().findAll();
    }

    public Iterable<T> findAll(Iterable<Long> ids) {
        return getDao().findAll(ids);
    }

    public Long count() {
        return getDao().count();
    }

    @Transactional(readOnly = false)
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        getDao().delete(id);
    }

    @Transactional(readOnly = false)
    public void delete(Iterable<? extends T> entities) {
        getDao().delete(entities);
    }

    public boolean exists(Long id) {
        return getDao().exists(id);
    }


    /**
     * 返回实体里的sql执行语句
     *
     * @param sqlStr
     * @param cls
     * @return
     */
    public List<BaseEntity> querySql(String sqlStr, Class<? extends BaseEntity> cls) {
        List<BaseEntity> list = getSession().createSQLQuery(sqlStr).addEntity(cls).list();
        return list;
    }

    /**
     * 返回实体里的sql执行语句
     *
     * @param sqlStr
     * @param cls
     * @return
     */
    public BaseEntity queryOneSql(String sqlStr, Class<? extends BaseEntity> cls) {
        List<BaseEntity> list = getSession().createSQLQuery(sqlStr).addEntity(cls).list();
        return list.get(0);
    }

    /**
     * 返回
     * @param sqlStr
     * @param properties
     * @return
     */
    public List<Map<Object, Object>> querySql(String sqlStr, String[] properties) {
        List<Map<Object, Object>> resultSet = new LinkedList<Map<Object, Object>>();
        List<Object[]> querySet = getSession().createSQLQuery(sqlStr).list();
        for (int i=0; i<querySet.size(); i++){
            Map<Object, Object> element = new HashMap<Object, Object>();
            if (properties.length == 1){
                element.put(properties[0], querySet.get(i));
                resultSet.add(element);
            }else {
                for (int j=0; j<properties.length; j++){
                    element.put(properties[j], querySet.get(i)[j]);
                }
                resultSet.add(element);
            }
        }
        return resultSet;
    }
}
