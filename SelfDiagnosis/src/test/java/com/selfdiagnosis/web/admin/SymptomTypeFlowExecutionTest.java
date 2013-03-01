package com.selfdiagnosis.web.admin;

import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntityTest;

/**
 * Test for symptomType flow.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomTypeFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/symptomType.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
    }

    @Override
    public SymptomTypeEntity testFlowOnStartEdit() {
        SymptomTypeEntity symptomType = createEntity();
        symptomType.setId(1L);
        return symptomType;
    }

    @Override
    public SymptomTypeEntity createEntity() {
        return SymptomTypeEntityTest.createValidSymptomTypeEntity();
    }

    @Override
    public String getFormName() {
        return "symptomTypeForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        // do nothing
    }

}
