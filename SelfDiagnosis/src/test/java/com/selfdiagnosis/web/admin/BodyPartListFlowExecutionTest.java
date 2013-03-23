package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.BodyPartEntityTest;

/**
 * Test for bodyPart list flow.
 * 
 * @author mmieszkowski
 * 
 */
public class BodyPartListFlowExecutionTest extends ParentListFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/bodyPartList.xml");
    }

    @Override
    public void entityListOnRender() {
        List<BodyPartEntity> bodyPartList = new ArrayList<BodyPartEntity>();
        EasyMock.expect(getAdminServiceMock().getBodyPartList()).andReturn(bodyPartList);
    }

    @Override
    public BodyPartEntity createEntity() {
        return BodyPartEntityTest.createValidBodyPartEntity();
    }

    @Override
    public String getFormName() {
        return "bodyPartList.jsp";
    }

    @Override
    public String getSubflowName() {
        return "bodyPart";
    }

}
