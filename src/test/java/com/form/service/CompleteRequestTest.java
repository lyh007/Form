package com.form.service;

import com.form.base.BaseTestCase;
import com.form.model.CompleteRequest;
import org.junit.Test;

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
        CompleteRequest completeRequest=new CompleteRequest();
        // completeRequest.set
        //completeRequestService.save();
    }
}
