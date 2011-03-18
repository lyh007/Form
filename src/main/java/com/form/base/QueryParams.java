package com.form.base;

/**
 * 查询参数基类
 */
public class QueryParams<T> {
    private T entity;
    /**
     * 可以通过该参数直接指定查询多少条。对于搜索引擎来说，如果该参数不为0，那么分页参数<code>paging</code>将被忽略
     */
    private int limit;

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }

    public QueryParams() {
    }

    public QueryParams(T entity) {
        setEntity(entity);
    }

    private Page paging = new Page();

    /**
     * @return the paging
     */
    public Page getPaging() {
        return paging;
    }

    /**
     * @param paging the paging to set
     */
    public void setPaging(Page paging) {
        this.paging = paging;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
