package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.TestTypeEntity;
import com.selfdiagnosis.core.entity.TestTypeEntityTest;

/**
 * Test for testType list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class TestTypeListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/testTypeList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<TestTypeEntity> testTypeList = new ArrayList<TestTypeEntity>();
        EasyMock.expect(getAdminServiceMock().getTestTypeList()).andReturn(testTypeList);
    }

    @Override
    public TestTypeEntity createEntity() {
        return TestTypeEntityTest.createValidTestTypeEntity();
    }

    @Override
    public String getFormName() {
        return "testTypeList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "testType";
    }

}
