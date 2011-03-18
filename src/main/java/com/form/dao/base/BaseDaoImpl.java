package com.form.dao.base;

import com.form.base.DomainObject;
import com.form.base.QueryParams;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO基类。针对数据库的读、写操作分别采用不同的Template,可以在一定程度上防止大量并发造成的死锁。
 */
public class BaseDaoImpl<T extends DomainObject> {
    /**
     * 分页statement后缀：_count
     */
    protected static final String COUNT_STATEMENT_SUFFIX = "_count";

    /**
     * 实体类
     */
    private String entityClass;

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 根据T类型来算出带命名空间的函数名
     *
     * @return 返回类型为 ClassName.methodName
     */
    public String getStatement() {
        StackTraceElement[] stacks = new Exception().getStackTrace();
        return getStatement(stacks[1].getMethodName());
    }

    /**
     * 根据T类型来算出带命名空间的函数名
     *
     * @param methodName 方法名
     * @return 返回类型为 ClassName.methodName
     */
    public String getStatement(String methodName) {
        ParameterizedType type = ((ParameterizedType) getClass().getGenericSuperclass());
        Class<T> entityClass = (Class<T>) (type.getActualTypeArguments()[0]);
        return entityClass.getName() + "." + methodName;
    }

    /**
     * 新增实体
     *
     * @param statement 语句
     * @param entity    实体类
     * @return 数据库标识
     */
    public DomainObject save(String statement, DomainObject entity) {
        int entityId = sqlSessionFactory.openSession().insert(statement, entity);
        if (entityId > 0) {
            entity.setId(entityId);
        }
        return entity;
    }

    public void save(T entity) {
        this.save(getStatement(), entity);

    }

    public void update(String statement, Object params) {
        sqlSessionFactory.openSession().update(statement, params);
    }

    public void update(T entity) {
        this.update(getStatement(), entity);
    }

    public void delete(String statement, Object params) {
        sqlSessionFactory.openSession().delete(statement, params);
    }

    public void delete(Long id) {
        delete(getStatement(), id);
    }

    public void deleteByIds(String ids) {
        deleteByIds(getStatement(), ids);
    }

    /**
     * 批量删除
     *
     * @param statement
     * @param params
     */
    public void deleteByIds(String statement, Object params) {
        sqlSessionFactory.openSession().delete(statement, params);
    }

    /**
     * 根据参数取得<code>T</code>类型实体
     *
     * @param statement
     * @param params
     * @return
     */
    public T getEntity(String statement, Object params) {
        return (T) sqlSessionFactory.openSession().selectOne(statement, params);
    }

    public T getById(Long id) {
        return this.getEntity(getStatement(), id);
    }

    /**
     * 根据参数查询列表，可分页
     *
     * @param statement
     * @param params
     * @return
     */
    public List<T> query(String statement, QueryParams params) {
        if (params != null && params.getPaging() != null) {
            int records = queryCount(statement, params);
            //如果查询出符合条件的记录数为0，那么就直接返回一个空的List，因为后面的已经没有执行的必要
            if (records == 0) {
                return new ArrayList<T>(0);
            }
            params.getPaging().setRecords(records);
        }
        return (List<T>) sqlSessionFactory.openSession().selectList(statement, params);
    }

    /**
     * 查询列表，不提供分页功能
     *
     * @param statement
     * @param params
     * @return
     */
    public List<T> query(String statement, Object params) {
        return (List<T>) sqlSessionFactory.openSession().selectList(statement, params);
    }

    /**
     * 根据参数判断该记录是否已存在（逻辑上存在）
     *
     * @param statement
     * @param params
     * @return
     */
    public boolean isExistEntity(String statement, Object params) {
        return (Integer) sqlSessionFactory.openSession().selectOne(statement, params) > 0;
    }

    /**
     * 查询符合条件的记录数，仅供分页查询调用。
     *
     * @param statement
     * @param params
     * @return
     */
    public int queryCount(String statement, QueryParams<?> params) {
        if (params == null)
            return (Integer) sqlSessionFactory.openSession().selectOne(statement + COUNT_STATEMENT_SUFFIX);
        return (Integer) sqlSessionFactory.openSession().selectOne(statement + COUNT_STATEMENT_SUFFIX, params);
    }

    public int getTotalCount(Object params) {
        return uniqueIntResult(getStatement("queryByPage") + COUNT_STATEMENT_SUFFIX, params);
    }

    public List<T> queryByPage(QueryParams<?> queryParams) {
        return this.query(getStatement(), queryParams);
    }

    /**
     * 根据条件查询整数结果。
     *
     * @param statement
     * @param params
     * @return
     */
    public int uniqueIntResult(String statement, Object params) {
        if (params == null)
            return (Integer) sqlSessionFactory.openSession().selectOne(statement);
        else
            return (Integer) sqlSessionFactory.openSession().selectOne(statement, params);
    }
}
