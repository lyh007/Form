package com.form.base;

import java.util.List;

/**
 * 公共接口，包括添加、修改、删除、通过id查询、分页查询、查询总数
 */
public interface BaseInterface<T> {
    /**
     * 保存
     *
     * @param entity
     */
    public void save(T entity);

    /**
     * 修改
     *
     * @param entity
     */
    public void update(T entity);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(Long id);

    /**
     * 批量删除
     */
    public void deleteByIds(String ids);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    public T getById(Long id);

    /**
     * 分页查询
     *
     * @param queryParams
     * @return
     */
    public List<T> queryByPage(QueryParams<?> queryParams);

    /**
     * 获取总数
     *
     * @param params
     * @return
     */
    public int getTotalCount(Object params);
}
