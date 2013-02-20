package com.selfdiagnosis.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.core.collection.LocalAttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.service.AdminService;

/**
 * Test for disease flow.
 * 
 * @author mmieszkowski
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DiseaseFlowExecutionTest extends AbstractXmlFlowExecutionTests {

    @Autowired
    private AdminService adminService;

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/disease.xml");
    }

    @Override
    protected FlowDefinitionResource[] getModelResources(FlowDefinitionResourceFactory resourceFactory) {
        return new FlowDefinitionResource[] { resourceFactory
                .createFileResource("src/main/webapp/WEB-INF/jsp/admin/parent-flow.xml") };
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        builderContext.registerBean("adminService", adminService);
        builderContext.registerBean("diseaseBean", new DiseaseEntity());
    }

    /**
     * Tests disease flow start.
     */
    @Test
    public void testStartDiseaseFlow() {
        DiseaseEntity disease = new DiseaseEntity();

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("entity", disease);
        MockExternalContext context = new MockExternalContext();
        startFlow(input, context);

        assertCurrentStateEquals("entityForm");
    }

    
    @Test
    @Transactional
    @Rollback
    public void testEntityForm_Save() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", createTestDiseaseEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("save");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals("diseaseForm.jsp", context);
        assertNotNull(((DiseaseEntity)(getFlowScope().get("entity"))).getName());
    }
    
    @Test
    @Transactional
    @Rollback
    public void testEntityForm_SaveAndBack() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", createTestDiseaseEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("saveAndBack");
        resumeFlow(context);

        assertFlowExecutionEnded();
        assertFlowExecutionOutcomeEquals("saveAndBack");
    }

    @Test
    @Transactional
    @Rollback
    public void testEntityForm_Back() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", new DiseaseEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("back");
        resumeFlow(context);

        assertFlowExecutionEnded();
        assertFlowExecutionOutcomeEquals("back");
    }

    @Test
    @Transactional
    @Rollback
    public void testEntityForm_SaveAndNew() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", createTestDiseaseEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("saveAndNew");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals("diseaseForm.jsp", context);
        assertNull(((DiseaseEntity)(getFlowScope().get("entity"))).getName());
    }
    
    private DiseaseEntity createTestDiseaseEntity(){
        DiseaseEntity disease = new DiseaseEntity();
        disease.setName("Flu");
        disease.setFrequency(new Short("50"));
        return disease;
    }
}
