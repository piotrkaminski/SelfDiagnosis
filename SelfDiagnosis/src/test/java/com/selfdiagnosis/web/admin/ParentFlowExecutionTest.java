package com.selfdiagnosis.web.admin;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.webflow.test.MockFlowBuilderContext;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SpringWebContextTest;

/**
 * Parent test for all flows.
 * 
 * @author mmieszkowski
 * 
 */
public abstract class ParentFlowExecutionTest extends SpringWebContextTest {

    /**
     * {@link AdminService} injected by Spring.
     */
    @Autowired
    private AdminService adminService;

    /**
     * {@link AdminService} to mock.
     */
    private AdminService adminServiceMock;

    /**
     * EasyMock set up.
     */
    @Before
    public void setUp() {
        setAdminServiceMock(EasyMock.createMock(AdminService.class));
    }

    @Override
    protected abstract FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory);

    @Override
    protected FlowDefinitionResource[] getModelResources(FlowDefinitionResourceFactory resourceFactory) {
        return new FlowDefinitionResource[] { resourceFactory
                .createFileResource("src/main/webapp/WEB-INF/jsp/admin/parent-flow.xml") };
    }

    @Override
    protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {
        builderContext.registerBean("adminService", getAdminServiceMock());
        builderContext.registerBean("diseaseBean", new DiseaseEntity());
        builderContext.registerBean("symptomBean", new SymptomEntity());
        builderContext.registerBean("bodyPartBean", new BodyPartEntity());
        builderContext.registerBean("symptomTypeBean", new SymptomTypeEntity());
        builderContext.registerBean("testBean", new SymptomTypeEntity());
        builderContext.registerBean("testTypeBean", new SymptomTypeEntity());
    }

    /**
     * Tests symptom flow start with new symptom entity.
     */
    @Test
    public void testStartFlowCreate() {

        testFlowOnStartCreate();
        EasyMock.replay(getAdminServiceMock());

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("entity", null);
        MockExternalContext context = new MockExternalContext();
        startFlow(input, context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        assertTrue(getRequiredFlowAttribute("entity") instanceof SelfDiagnosisEntity);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Represents <on-start> action in the flow.
     */
    public abstract void testFlowOnStartCreate();
    
    /**
     * Tests disease flow start with existing disease.
     */
    @Test
    @Transactional
    public void testStartFlowEdit() {
        SelfDiagnosisEntity entity = testFlowOnStartEdit();
        EasyMock.replay(getAdminServiceMock());

        MutableAttributeMap input = new LocalAttributeMap();
        input.put("entity", entity);
        MockExternalContext context = new MockExternalContext();
        startFlow(input, context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        assertTrue(getRequiredFlowAttribute("entity") instanceof SelfDiagnosisEntity);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Represents <on-start> action in the flow with entity creation.
     * @return created entity
     */
    public abstract SelfDiagnosisEntity testFlowOnStartEdit();
    
    /**
     * Tests save event.
     */
    @Test
    @Transactional
    public void testEntityFormSave() {
        SelfDiagnosisEntity entity = createEntity();
        SelfDiagnosisEntity savedEntity = createEntity();
        savedEntity.setId(1L);

        entityFormOnRender();
        EasyMock.expect(getAdminServiceMock().saveEntity(entity)).andReturn(savedEntity);
        EasyMock.replay(getAdminServiceMock());

        setCurrentState("entityForm");
        getFlowScope().put("entity", entity);

        MockExternalContext context = new MockExternalContext();
        context.setEventId("save");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        assertEquals(((SelfDiagnosisEntity) (getFlowScope().get("entity"))).getId().longValue(), 1L);
        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Tests saveAndBack event.
     */
    @Test
    @Transactional
    public void testEntityFormSaveAndBack() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", createEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("saveAndBack");
        resumeFlow(context);

        assertFlowExecutionEnded();
        assertFlowExecutionOutcomeEquals("saveAndBack");
    }

    /**
     * Tests back event.
     */
    @Test
    @Transactional
    public void testEntityFormBack() {
        setCurrentState("entityForm");
        getFlowScope().put("entity", createEntity());

        MockExternalContext context = new MockExternalContext();
        context.setEventId("back");
        resumeFlow(context);

        assertFlowExecutionEnded();
        assertFlowExecutionOutcomeEquals("back");
    }

    /**
     * Tests saveAndNew event.
     */
    @Test
    @Transactional
    public void testEntityFormSaveAndNew() {
        SelfDiagnosisEntity entity = createEntity();

        entityFormOnRender();
        EasyMock.expect(getAdminServiceMock().saveEntity(entity)).andReturn(entity);
        EasyMock.replay(getAdminServiceMock());

        setCurrentState("entityForm");
        getFlowScope().put("entity", entity);

        MockExternalContext context = new MockExternalContext();
        context.setEventId("saveAndNew");
        resumeFlow(context);

        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        assertNull(((SelfDiagnosisEntity) (getFlowScope().get("entity"))).getId());

        EasyMock.verify(getAdminServiceMock());
    }

    /**
     * Universal method for subflow test.
     * 
     * @param symptomSubflow
     *            subflow to test
     * @param eventName
     *            name of flow event
     * @return disease entity processed by the flow
     */
    public SelfDiagnosisEntity testFlowAddNewEntity(Flow symptomSubflow, String eventName) {
        SelfDiagnosisEntity entity = createEntity();
        setCurrentState("entityForm");
        getFlowScope().put("entity", entity);

        getFlowDefinitionRegistry().registerFlowDefinition(symptomSubflow);
        MockExternalContext context = new MockExternalContext();
        context.setEventId(eventName);
        resumeFlow(context);

        assertFlowExecutionActive();
        assertCurrentStateEquals("entityForm");
        assertResponseWrittenEquals(getFormName(), context);
        return entity;
    }
    
    /**
     * @param subflowName
     *            name of the subflow
     * @return subflow mock with back output event
     */
    public Flow createMockSubflowBackOutput(String subflowName) {
        Flow mockBodyPartFlow = new Flow(subflowName);
        new EndState(mockBodyPartFlow, "back");

        return mockBodyPartFlow;
    }

    /**
     * @param subflowName
     *            name of the subflow
     * @param entity
     *            that subflow should return
     * @return subflow mock with saveAndBack output event
     */
    public Flow createMockSubflowSaveAndBackOutput(String subflowName, final SelfDiagnosisEntity entity) {
        Flow mockSymptomFlow = new Flow(subflowName);
        EndState endState = new EndState(mockSymptomFlow, "saveAndBack");
        endState.setOutputMapper(new Mapper() {

            @Override
            public MappingResults map(Object source, Object target) {
                ((LocalAttributeMap) target).put("entity", entity);
                return null;
            }
        });

        return mockSymptomFlow;
    }
    
    /**
     * Represents action in <on-render> block of entityForm.
     */
    public abstract void entityFormOnRender();

    /**
     * Creates entity - with no id.
     * 
     * @return new entity
     */
    public abstract SelfDiagnosisEntity createEntity();

    /**
     * @return jsp form file name
     */
    public abstract String getFormName();

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public AdminService getAdminServiceMock() {
        return adminServiceMock;
    }

    public void setAdminServiceMock(AdminService adminServiceMock) {
        this.adminServiceMock = adminServiceMock;
    }

}
