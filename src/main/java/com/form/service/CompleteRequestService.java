package com.form.service;

import com.form.base.QueryParams;
import com.form.mapper.CompleteRequestMapper;
import com.form.model.CompleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("completeRequest")
@Transactional
public class CompleteRequestService {
    @Autowired
    private CompleteRequestMapper completeRequestMapper;

    /**
     * save
     *
     * @param completeRequest
     */
    public void save(CompleteRequest completeRequest) {
        completeRequestMapper.save(completeRequest);
    }

    /**
     * update
     *
     * @param CompleteRequest
     */
    public void update(CompleteRequest CompleteRequest) {
        completeRequestMapper.update(CompleteRequest);
    }

    /**
     * delete
     *
     * @param id
     */
    public void delete(Long id) {
        completeRequestMapper.delete(id);
    }

    /**
     * get by id
     *
     * @param id
     * @return CompleteRequest
     */
    public CompleteRequest getById(Long id) {
        return completeRequestMapper.getById(id);
    }

    /**
     * search by page
     *
     * @param queryParams
     * @return T type List
     */
    public List<CompleteRequest> queryByPage(QueryParams<?> queryParams) {
        return completeRequestMapper.queryByPage(queryParams);
    }

    /**
     * get query count
     *
     * @param params parameters object
     * @return count
     */
    public int getTotalCount(Object params) {
        return completeRequestMapper.getTotalCount(params);
    }
}
