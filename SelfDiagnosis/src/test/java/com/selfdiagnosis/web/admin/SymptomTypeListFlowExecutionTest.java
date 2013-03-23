package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntityTest;

/**
 * Test for symptomType list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomTypeListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/symptomTypeList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<SymptomTypeEntity> symptomTypeList = new ArrayList<SymptomTypeEntity>();
        EasyMock.expect(getAdminServiceMock().getSymptomTypeList()).andReturn(symptomTypeList);
    }

    @Override
    public SymptomTypeEntity createEntity() {
        return SymptomTypeEntityTest.createValidSymptomTypeEntity();
    }

    @Override
    public String getFormName() {
        return "symptomTypeList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "symptomType";
    }

}
