package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomEntityTest;

/**
 * Test for symptom list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/symptomList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<SymptomEntity> symptomList = new ArrayList<SymptomEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomList()).andReturn(symptomList);
    }

    @Override
    public SymptomEntity createEntity() {
        return SymptomEntityTest.createValidSymptomEntity();
    }

    @Override
    public String getFormName() {
        return "symptomList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "symptom";
    }

}
