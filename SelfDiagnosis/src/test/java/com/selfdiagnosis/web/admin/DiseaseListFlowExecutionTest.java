package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseEntityTest;

/**
 * Test for disease list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class DiseaseListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/diseaseList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<DiseaseEntity> diseaseList = new ArrayList<DiseaseEntity>();
        EasyMock.expect(getAdminServiceMock().getDiseaseList()).andReturn(diseaseList);
    }

    @Override
    public DiseaseEntity createEntity() {
        return DiseaseEntityTest.createValidDiseaseEntity();
    }

    @Override
    public String getFormName() {
        return "diseaseList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "disease";
    }

}
