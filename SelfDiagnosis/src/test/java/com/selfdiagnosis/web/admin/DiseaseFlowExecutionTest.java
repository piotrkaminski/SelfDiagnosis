package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockParameterMap;

import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseEntityTest;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomEntityTest;

/**
 * Test for disease flow.
 * 
 * @author mmieszkowski
 * 
 */
public class DiseaseFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/disease.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
        List<SymptomEntity> symptomList = new ArrayList<SymptomEntity>();
        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomList()).andReturn(symptomList);
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(null)).andReturn(diseaseSymptomList);
    }

    @Override
    public DiseaseEntity testFlowOnStartEdit() {
        DiseaseEntity disease = createEntity();
        disease.setId(1L);

        List<SymptomEntity> symptomList = new ArrayList<SymptomEntity>();
        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomList()).andReturn(symptomList);
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(1L)).andReturn(diseaseSymptomList);
        return disease;
    }

    /**
     * Tests disease flow. addNewDiseaseSymptom event.
     */
    @Test
    @Transactional
    public void testDiseaseFlowAddNewDiseaseSymptom() {
        DiseaseEntity disease = createEntity();

        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();

        EasyMock.expect(getAdminServiceMock().saveEntity(disease)).andReturn(disease);
        disease.setId(1L);
        getAdminServiceMock().addNewDiseaseSymptom(disease);
        EasyMock.expectLastCall().once();
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(1L)).andReturn(diseaseSymptomList);

        EasyMock.replay(getAdminServiceMock());

        setCurrentState("entityForm");
        getFlowScope().put("entity", disease);

        MockExternalContext context = new MockExternalContext();
        context.setEventId("addNewDiseaseSymptom");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals("diseaseForm.jsp", context);
        assertTrue(getRequiredFlowAttribute("entity") instanceof DiseaseEntity);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Tests disease flow. addNewDiseaseSymptom event.
     */
    @Test
    @Transactional
    public void testDiseaseFlowDeleteDiseaseSymptom() {
        DiseaseEntity disease = createEntity();
        disease.setId(1L);
        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();
        DiseaseSymptomEntity diseaseSymptom = new DiseaseSymptomEntity();
        diseaseSymptom.setId(2L);

        getAdminServiceMock().deleteDiseaseSymptom(diseaseSymptom);
        EasyMock.expectLastCall().once();
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(1L)).andReturn(diseaseSymptomList);

        EasyMock.replay(getAdminServiceMock());

        setCurrentState("entityForm");
        getFlowScope().put("entity", disease);
        getFlowScope().put("diseaseSymptom", new DiseaseSymptomEntity());
        MockParameterMap requestParameterMap = new MockParameterMap();
        requestParameterMap.put("diseaseSymptom", "2");
        MockExternalContext context = new MockExternalContext();
        context.setRequestParameterMap(requestParameterMap);
        context.setEventId("deleteDiseaseSymptom");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals("diseaseForm.jsp", context);
        assertTrue(getRequiredFlowAttribute("entity") instanceof DiseaseEntity);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Tests symptom subflow with no output.
     */
    @Test
    @Transactional
    public void testDiseaseFlowAddNewSymptomBack() {
        DiseaseEntity disease = (DiseaseEntity) testFlowAddNewEntity(createMockSubflowBackOutput("symptom"),
                "addNewSymptom");
        assertNull(disease.getDiseaseSymptom().getSymptom());

    }

    /**
     * Tests symptom subflow with output.
     */
    @Test
    @Transactional
    public void testDiseaseFlowAddNewSymptomSaveAndBack() {
        DiseaseEntity disease = (DiseaseEntity) testFlowAddNewEntity(
                createMockSubflowSaveAndBackOutput("symptom", createSymptom()), "addNewSymptom");
        assertEquals(1L, disease.getDiseaseSymptom().getSymptom().getId().longValue());
    }

    /**
     * Creates symptom in order to test symptom subflow.
     * 
     * @return symptom entity with id
     */
    public SymptomEntity createSymptom() {
        SymptomEntity symptom = SymptomEntityTest.createValidSymptomEntity();
        symptom.setId(1L);
        return symptom;
    }

    @Override
    public DiseaseEntity createEntity() {
        return DiseaseEntityTest.createValidDiseaseEntity();
    }

    @Override
    public String getFormName() {
        return "diseaseForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        // do nothing
    }

}
