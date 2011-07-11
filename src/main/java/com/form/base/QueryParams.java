package com.form.base;

/**
 * Query condition base Class
 */
public class QueryParams<T> {
    private T entity;
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
