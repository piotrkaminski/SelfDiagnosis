package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.TestEntity;
import com.selfdiagnosis.core.entity.TestEntityTest;

/**
 * Test for test list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class TestListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/testList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<TestEntity> testList = new ArrayList<TestEntity>();
        EasyMock.expect(getAdminServiceMock().getTestList()).andReturn(testList);
    }

    @Override
    public TestEntity createEntity() {
        return TestEntityTest.createValidTestEntity();
    }

    @Override
    public String getFormName() {
        return "testList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "test";
    }

}
