package com.selfdiagnosis.web.admin;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.TestTypeEntity;
import com.selfdiagnosis.core.entity.TestTypeEntityTest;

/**
 * Test for testType flow.
 * 
 * @author mmieszkowski
 * 
 */
public class TestTypeFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/testType.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
    }

    @Override
    public TestTypeEntity testFlowOnStartEdit() {
        TestTypeEntity testType = createEntity();
        testType.setId(1L);
        return testType;
    }

    @Override
    public TestTypeEntity createEntity() {
        return TestTypeEntityTest.createValidTestTypeEntity();
    }

    @Override
    public String getFormName() {
        return "testTypeForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        // do nothing
    }

}
