package com.form.dao.base;

import com.form.base.DomainObject;
import com.form.base.QueryParams;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Base Class
 */
public class BaseDaoImpl<T extends DomainObject> {
    /**
     * page sql statement Suffix：_count
     */
    protected static final String COUNT_STATEMENT_SUFFIX = "_count";

    /**
     * Enitty class
     */
    private String entityClass;

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    /**
     * T calculated according to the type of function names with namespace
     *
     * @return ClassName.methodName
     */
    public String getStatement() {
        StackTraceElement[] stacks = new Exception().getStackTrace();
        return getStatement(stacks[1].getMethodName());
    }

    /**
     * T calculated according to the type of function names with namespace
     *
     * @param methodName method name
     * @return return type ClassName.methodName
     */
    public String getStatement(String methodName) {
        ParameterizedType type = ((ParameterizedType) getClass().getGenericSuperclass());
        Class<T> entityClass = (Class<T>) (type.getActualTypeArguments()[0]);
        return entityClass.getName() + "." + methodName;
    }

    /**
     * add entity
     *
     * @param statement statement
     * @param entity    entity instance
     * @return Domain Object
     */
    public DomainObject save(String statement, DomainObject entity) {
        int entityId = sqlSessionFactory.openSession().insert(statement, entity);
        if (entityId > 0) {
            entity.setId(entityId);
        }
        return entity;
    }

    /**
     * save an entity
     *
     * @param entity
     */
    public void save(T entity) {
        this.save(getStatement(), entity);

    }

    /**
     * update an entity
     *
     * @param statement statement
     * @param params    paramters
     */
    public void update(String statement, Object params) {
        sqlSessionFactory.openSession().update(statement, params);
    }

    /**
     * update an entity
     *
     * @param entity entity instance
     */
    public void update(T entity) {
        this.update(getStatement(), entity);
    }

    /**
     * delte a record
     *
     * @param statement statement
     * @param params    paramenters
     */
    public void delete(String statement, Object params) {
        sqlSessionFactory.openSession().delete(statement, params);
    }

    /**
     * delete a record by ID
     *
     * @param id ID
     */
    public void delete(Long id) {
        delete(getStatement(), id);
    }

    /**
     * delete records by Ids
     *
     * @param ids Ids
     */
    public void deleteByIds(String ids) {
        deleteByIds(getStatement(), ids);
    }

    /**
     * batch delete
     *
     * @param statement statement
     * @param params    Parameters
     */
    public void deleteByIds(String statement, Object params) {
        sqlSessionFactory.openSession().delete(statement, params);
    }

    /**
     * According to the parameters obtained <code> T </ code> type of entity
     *
     * @param statement statement
     * @param params    parameters
     * @return Type of T
     */
    public T getEntity(String statement, Object params) {
        return (T) sqlSessionFactory.openSession().selectOne(statement, params);
    }

    /**
     * get Type Of T object by ID
     *
     * @param id ID
     * @return Type of T object
     */
    public T getById(Long id) {
        return this.getEntity(getStatement(), id);
    }

    /**
     * Query T type List by page
     *
     * @param statement statement
     * @param params    query parameters
     * @return Type of T list
     */
    public List<T> query(String statement, QueryParams params) {
        if (params != null && params.getPaging() != null) {
            int records = queryCount(statement, params);
            // if recors size equal zero return a new list
            if (records == 0) {
                return new ArrayList<T>(0);
            }
            params.getPaging().setRecords(records);
        }
        return (List<T>) sqlSessionFactory.openSession().selectList(statement, params);
    }

    /**
     * query list
     *
     * @param statement statement
     * @param params    query parameters
     * @return Type of T list
     */
    public List<T> query(String statement, Object params) {
        return (List<T>) sqlSessionFactory.openSession().selectList(statement, params);
    }

    /**
     * According to the parameters to determine whether the record already exists (logically exists)
     *
     * @param statement statement
     * @param params    paramters
     * @return if exists return true.
     */
    public boolean isExistEntity(String statement, Object params) {
        return (Integer) sqlSessionFactory.openSession().selectOne(statement, params) > 0;
    }

    /**
     * Query matches the number of records, only for paging query calls.
     *
     * @param statement statements
     * @param params    query paramters
     * @return count
     */
    public int queryCount(String statement, QueryParams<?> params) {
        if (params == null)
            return (Integer) sqlSessionFactory.openSession().selectOne(statement + COUNT_STATEMENT_SUFFIX);
        return (Integer) sqlSessionFactory.openSession().selectOne(statement + COUNT_STATEMENT_SUFFIX, params);
    }

    /**
     * The number of records for the specified parameters
     *
     * @param params paramters
     * @return count
     */
    public int getTotalCount(Object params) {
        return uniqueIntResult(getStatement("queryByPage") + COUNT_STATEMENT_SUFFIX, params);
    }

    /**
     * Query page
     *
     * @param queryParams query parameters
     * @return Type of T list
     */
    public List<T> queryByPage(QueryParams<?> queryParams) {
        return this.query(getStatement(), queryParams);
    }

    /**
     * According to criteria query integer result.
     *
     * @param statement statement
     * @param params    paramters
     * @return Integer type
     */
    public int uniqueIntResult(String statement, Object params) {
        if (params == null)
            return (Integer) sqlSessionFactory.openSession().selectOne(statement);
        else
            return (Integer) sqlSessionFactory.openSession().selectOne(statement, params);
    }
}
