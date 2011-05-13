package com.form.base;

import java.util.List;

/**
 * public interace:contain add,update,delete,get by id,query by page function etc.
 */
public interface BaseInterface<T> {
    /**
     * save
     *
     * @param entity
     */
    public void save(T entity);

    /**
     * update
     *
     * @param entity
     */
    public void update(T entity);

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id);

    /**
     * batch delete
     */
//    public void deleteByIds(String ids);

    /**
     * get by id
     *
     * @param id
     * @return T
     */
    public T getById(Long id);

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<T> queryByPage(QueryParams<?> queryParams);

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params);
}
