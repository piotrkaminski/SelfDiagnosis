package com.selfdiagnosis.web.admin;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.BodyPartEntityTest;

/**
 * Test for bodyPart flow.
 * 
 * @author mmieszkowski
 * 
 */
public class BodyPartFlowExecutionTest extends ParentFlowExecutionTest {

    @Override
    protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {
        return resourceFactory.createFileResource("src/main/webapp/WEB-INF/jsp/admin/bodyPart.xml");
    }

    @Override
    public void testFlowOnStartCreate() {
        entityFormOnRender();
    }

    @Override
    public BodyPartEntity testFlowOnStartEdit() {
        BodyPartEntity bodyPart = createEntity();
        bodyPart.setId(1L);

        entityFormOnRender();
        return bodyPart;
    }

    @Override
    public BodyPartEntity createEntity() {
        return BodyPartEntityTest.createValidBodyPartEntity();
    }

    @Override
    public String getFormName() {
        return "bodyPartForm.jsp";
    }

    @Override
    public void entityFormOnRender() {
        List<BodyPartEntity> bodyPartList = new ArrayList<BodyPartEntity>();
        EasyMock.expect(getAdminServiceMock().getBodyPartList()).andReturn(bodyPartList);
    }

}
