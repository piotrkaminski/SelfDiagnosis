package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.binding.mapping.Mapper;
import org.springframework.binding.mapping.MappingResults;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.engine.EndState;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.test.MockExternalContext;

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

    /**
     * Tests disease flow start with new disease entity.
     */
    @Test
    public void testStartDiseaseFlowCreate() {

        List<SymptomEntity> symptomList = new ArrayList<SymptomEntity>();
        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomList()).andReturn(symptomList);
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(null)).andReturn(diseaseSymptomList);

        EasyMock.replay(getAdminServiceMock());

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("entity", null);
        MockExternalContext context = new MockExternalContext();
        startFlow(input, context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals("diseaseForm.jsp", context);
        assertTrue(getRequiredFlowAttribute("entity") instanceof DiseaseEntity);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Tests disease flow start with existing disease.
     */
    @Test
    @Transactional
    public void testStartDiseaseFlowEdit() {
        DiseaseEntity disease = createEntity();
        disease.setId(1L);

        List<SymptomEntity> symptomList = new ArrayList<SymptomEntity>();
        List<DiseaseSymptomEntity> diseaseSymptomList = new ArrayList<DiseaseSymptomEntity>();

        EasyMock.expect(getAdminServiceMock().getSymptomList()).andReturn(symptomList);
        EasyMock.expect(getAdminServiceMock().getDiseaseSymptomListForDisease(1L)).andReturn(diseaseSymptomList);

        EasyMock.replay(getAdminServiceMock());

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("entity", disease);
        MockExternalContext context = new MockExternalContext();
        startFlow(input, context);

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
    public void testDiseaseFlowAddNewSymptomNoOutput() {
        DiseaseEntity disease = testDiseaseFlowAddNewSymptom(createMockSymptomSubflowNoOutput());
        assertNull(disease.getDiseaseSymptom().getSymptom());
        
    }

    /**
     * Tests symptom subflow with output.
     */
    @Test
    @Transactional
    public void testDiseaseFlowAddNewSymptomWithOutput() {
        DiseaseEntity disease = testDiseaseFlowAddNewSymptom(createMockSymptomSubflowWithOutput());
        assertEquals(1L, disease.getDiseaseSymptom().getSymptom().getId().longValue());
    }

    /**
     * Universal method for symptom subflow test.
     * 
     * @param symptomSubflow
     *            subflow to test
     * @return disease entity processed by the flow
     */
    public DiseaseEntity testDiseaseFlowAddNewSymptom(Flow symptomSubflow) {
        DiseaseEntity disease = createEntity();

        EasyMock.replay(getAdminServiceMock());

        setCurrentState("entityForm");
        getFlowScope().put("entity", disease);

        getFlowDefinitionRegistry().registerFlowDefinition(symptomSubflow);
        MockExternalContext context = new MockExternalContext();
        context.setEventId("addNewSymptom");
        resumeFlow(context);

        assertFlowExecutionActive();
        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        EasyMock.verify(getAdminServiceMock());
        return disease;
    }

    /**
     * 
     * @return subflow mock
     */
    public Flow createMockSymptomSubflowNoOutput() {
        Flow mockSymptomFlow = new Flow("symptom");
        new EndState(mockSymptomFlow, "back");

        return mockSymptomFlow;
    }

    /**
     * 
     * @return subflow mock
     */
    public Flow createMockSymptomSubflowWithOutput() {
        Flow mockSymptomFlow = new Flow("symptom");
        EndState endState = new EndState(mockSymptomFlow, "saveAndBack");
        endState.setOutputMapper(new Mapper() {
            
            @Override
            public MappingResults map(Object source, Object target) {
                ((LocalAttributeMap) target).put("entity", createSymptom());

                return null;
            }
        });

        return mockSymptomFlow;
    }
    
    /**
     * Creates symptom in order to test symptom subflow.
     * 
     * @return symptom entity with id
     */
    public SymptomEntity createSymptom() {
        SymptomEntity symptom = new SymptomEntityTest().createValidEntity();
        symptom.setId(1L);
        return symptom;
    }

    @Override
    public DiseaseEntity createEntity() {
        return new DiseaseEntityTest().createValidEntity();
    }

    @Override
    public String getFormName() {
        return "diseaseForm.jsp";
    }

}
