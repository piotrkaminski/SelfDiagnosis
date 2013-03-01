package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.BodyPartEntityTest;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomEntityTest;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntityTest;
import com.selfdiagnosis.core.entity.TestEntity;
import com.selfdiagnosis.core.entity.TestEntityTest;

/**
 * Test for symptom flow.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/symptom.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
        List<BodyPartEntity> bodyPartList = new ArrayList<BodyPartEntity>();
        List<SymptomTypeEntity> symptomTypeList = new ArrayList<SymptomTypeEntity>();
        List<TestEntity> testList = new ArrayList<TestEntity>();
        EasyMock.expect(getAdminServiceMock().getBodyPartList()).andReturn(bodyPartList);
        EasyMock.expect(getAdminServiceMock().getSymptomTypeList()).andReturn(symptomTypeList);
        EasyMock.expect(getAdminServiceMock().getTestList()).andReturn(testList);
    }

    @Override
    public SymptomEntity testFlowOnStartEdit() {
        SymptomEntity symptom = createEntity();
        symptom.setId(1L);

        testFlowOnStartCreate();
        return symptom;
    }

    /**
     * Tests bodyPart subflow with no output.
     */
    @Test
    @Transactional
    public void testSymptomFlowAddNewBodyPartBack() {
        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(createMockSubflowBackOutput("bodyPart"),
                "addNewBodyPart");
        assertNull(symptom.getBodyPart().getId());

    }

    /**
     * Tests body part subflow with saveAndBack output event.
     */
    @Test
    @Transactional
    public void testSymptomFlowAddNewBodyPartSaveAndBack() {
        List<BodyPartEntity> bodyPartList = new ArrayList<BodyPartEntity>();
        EasyMock.expect(getAdminServiceMock().getBodyPartList()).andReturn(bodyPartList);
        EasyMock.replay(getAdminServiceMock());

        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(
                createMockSubflowSaveAndBackOutput("bodyPart", createBodyPart()), "addNewBodyPart");
        assertEquals(2L, symptom.getBodyPart().getId().longValue());
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Creates body part in order to test body part subflow.
     * 
     * @return body part entity with id
     */
    public BodyPartEntity createBodyPart() {
        BodyPartEntity bodyPart = BodyPartEntityTest.createValidBodyPartEntity();
        bodyPart.setId(2L);
        return bodyPart;
    }

    /**
     * Tests SymptomType subflow with no output.
     */
    @Test
    @Transactional
    public void testSymptomTypeFlowAddNewSymptomTypeBack() {
        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(createMockSubflowBackOutput("symptomType"),
                "addNewSymptomType");
        assertNull(symptom.getSymptomType().getId());

    }

    /**
     * Tests symptom subflow with output.
     */
    @Test
    @Transactional
    public void testSymptomFlowAddNewSymptomTypeSaveAndBack() {
        List<SymptomTypeEntity> symptomTypeList = new ArrayList<SymptomTypeEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomTypeList()).andReturn(symptomTypeList);
        EasyMock.replay(getAdminServiceMock());

        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(
                createMockSubflowSaveAndBackOutput("symptomType", createSymptomType()), "addNewSymptomType");
        assertEquals(2L, symptom.getSymptomType().getId().longValue());
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Creates body part in order to test body part subflow.
     * 
     * @return body part entity with id
     */
    public SymptomTypeEntity createSymptomType() {
        SymptomTypeEntity symptomType = SymptomTypeEntityTest.createValidSymptomTypeEntity();
        symptomType.setId(2L);
        return symptomType;
    }

    /**
     * Tests Test subflow with no output.
     */
    @Test
    @Transactional
    public void testTestFlowAddNewTestBack() {
        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(createMockSubflowBackOutput("test"), "addNewTest");
        assertNull(symptom.getTest());
    }

    /**
     * Tests symptom subflow with output.
     */
    @Test
    @Transactional
    public void testSymptomFlowAddNewTestSaveAndBack() {
        List<TestEntity> testList = new ArrayList<TestEntity>();
        EasyMock.expect(getAdminServiceMock().getTestList()).andReturn(testList);
        EasyMock.replay(getAdminServiceMock());

        SymptomEntity symptom = (SymptomEntity) testFlowAddNewEntity(
                createMockSubflowSaveAndBackOutput("test", createTest()), "addNewTest");
        assertEquals(2L, symptom.getTest().getId().longValue());
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Creates body part in order to test body part subflow.
     * 
     * @return body part entity with id
     */
    public TestEntity createTest() {
        TestEntity test = TestEntityTest.createValidTestEntity();
        test.setId(2L);
        return test;
    }

    @Override
    public SymptomEntity createEntity() {
        return SymptomEntityTest.createValidSymptomEntity();
    }

    @Override
    public String getFormName() {
        return "symptomForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        // do nothing
    }

}
