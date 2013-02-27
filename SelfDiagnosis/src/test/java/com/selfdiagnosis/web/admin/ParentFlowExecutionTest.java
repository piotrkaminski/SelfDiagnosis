package com.selfdiagnosis.web.admin;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;

import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
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
    }

    /**
     * Tests save event.
     */
    @Test
    @Transactional
    public void testEntityFormSave() {
        SelfDiagnosisEntity entity = createEntity();
        SelfDiagnosisEntity savedEntity = createEntity();
        savedEntity.setId(1L);

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
