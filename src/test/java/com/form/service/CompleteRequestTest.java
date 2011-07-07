package com.form.service;

import com.form.base.BaseTestCase;
import com.form.base.QueryParams;
import com.form.model.CompleteRequest;
import org.junit.Test;

import java.util.List;

/**
 * CompleteRequest TestCase
 */
public class CompleteRequestTest extends BaseTestCase {
    private CompleteRequestService completeRequestService;

    public CompleteRequestTest() {
        completeRequestService = (CompleteRequestService) getApplicationContext().getBean("completeRequestService");
    }

    @Test
    public void testSave() {
        CompleteRequest completeRequest = new CompleteRequest();
        // completeRequest.set
        //completeRequestService.save();
    }

    @Test
    public void testQueryByPage() {
        QueryParams<CompleteRequest> queryParams = new QueryParams<CompleteRequest>();
        CompleteRequest completeRequestParam = new CompleteRequest();
        completeRequestParam.setCompanyId(1L);
        completeRequestParam.setCompanyUserId(1L);
        queryParams.setEntity(completeRequestParam);
        List<CompleteRequest> completeRequests = completeRequestService.queryByPage(queryParams);
        if (completeRequests != null) {
            System.out.println(completeRequests.size());
        }
    }
}
