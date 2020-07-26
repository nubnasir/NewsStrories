package com.nubnasir.newsstories.common.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;

/**
 * Created by root on 9/9/18.
 */
public abstract class BaseRepository<T extends Object> {

    @Autowired
    @Qualifier(value = "sessionFactory")
    private SessionFactory sessionFactory;

    private Class<T> modelClass;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Criteria getCriteria(){
        return getSession().createCriteria(getModelClass());
    }

    public void create(T t){
        getSession().save(t);
    }

    public void update(T t){
        getSession().update(t);
    }

    public void delete(T t){
        getSession().delete(t);
    }

    public T getById(long id){
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (T) criteria.uniqueResult();
    }

    public Class<T> getModelClass() {
        if (modelClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.modelClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return modelClass;
    }

    public void setModelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }
}
