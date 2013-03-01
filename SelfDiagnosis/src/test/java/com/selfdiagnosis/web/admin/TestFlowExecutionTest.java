package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.TestEntity;
import com.selfdiagnosis.core.entity.TestEntityTest;
import com.selfdiagnosis.core.entity.TestTypeEntity;
import com.selfdiagnosis.core.entity.TestTypeEntityTest;

/**
 * Test for test flow.
 * 
 * @author mmieszkowski
 * 
 */
public class TestFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/test.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
        List<TestTypeEntity> testTypeList = new ArrayList<TestTypeEntity>();
        EasyMock.expect(getAdminServiceMock().getTestTypeList()).andReturn(testTypeList);
    }

    @Override
    public TestEntity testFlowOnStartEdit() {
        TestEntity test = createEntity();
        test.setId(1L);

        testFlowOnStartCreate();
        return test;
    }
    
    /**
     * Tests TestType subflow with no output.
     */
    @Test
    @Transactional
    public void testTypeTestTypeFlowAddNewTestTypeBack() {
        TestEntity test = (TestEntity) testFlowAddNewEntity(createMockSubflowBackOutput("testType"), "addNewTestType");
        assertNull(test.getTestType().getId());
    }

    /**
     * Tests testType subflow with output.
     */
    @Test
    @Transactional
    public void testTypeSymptomFlowAddNewTestTypeSaveAndBack() {
        List<TestTypeEntity> testTypeList = new ArrayList<TestTypeEntity>();
        EasyMock.expect(getAdminServiceMock().getTestTypeList()).andReturn(testTypeList);
        EasyMock.replay(getAdminServiceMock());

        TestEntity test = (TestEntity) testFlowAddNewEntity(
                createMockSubflowSaveAndBackOutput("testType", createTestType()), "addNewTestType");
        assertEquals(2L, test.getTestType().getId().longValue());
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Creates testTypeEntity in order to test subflow.
     * 
     * @return test type entity with id
     */
    public TestTypeEntity createTestType() {
        TestTypeEntity testType = TestTypeEntityTest.createValidTestTypeEntity();
        testType.setId(2L);
        return testType;
    }


    @Override
    public TestEntity createEntity() {
        return TestEntityTest.createValidTestEntity();
    }

    @Override
    public String getFormName() {
        return "testForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        //do nothing
    }

}
