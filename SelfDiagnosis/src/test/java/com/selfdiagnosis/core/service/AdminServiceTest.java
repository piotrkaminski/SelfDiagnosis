package com.selfdiagnosis.core.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.BodyPartEntityTest;
import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntityTest;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomEntityTest;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntityTest;
import com.selfdiagnosis.core.entity.TestEntity;
import com.selfdiagnosis.core.entity.TestEntityTest;
import com.selfdiagnosis.test.SpringContextTest;

/**
 * Test class for {@link AdminService}.
 * 
 * @author mmieszkowski
 * 
 */
public class AdminServiceTest extends SpringContextTest {

    /**
     * Service injected by Spring.
     */
    @Autowired
    private AdminService adminService;

    /**
     * Tests getBodyPartList() method.
     */
    @Test
    @Transactional
    public void getBodyPartListTest() {
        List<BodyPartEntity> bodyPartList = adminService.getBodyPartList();
        Assert.assertNotNull(bodyPartList);
        Assert.assertEquals(0, bodyPartList.size());

        BodyPartEntityTest entityTest = new BodyPartEntityTest();
        entityTest.saveEntity(entityTest.createValidEntity(), adminService);

        bodyPartList = adminService.getBodyPartList();
        Assert.assertEquals(1, bodyPartList.size());
    }

    /**
     * Tests getSymptomTypeList() method.
     */
    @Test
    @Transactional
    public void getSymptomTypeListTest() {
        List<SymptomTypeEntity> symptomTypeList = adminService.getSymptomTypeList();
        Assert.assertNotNull(symptomTypeList);
        Assert.assertEquals(0, symptomTypeList.size());

        SymptomTypeEntityTest entityTest = new SymptomTypeEntityTest();
        entityTest.saveEntity(entityTest.createValidEntity(), adminService);

        symptomTypeList = adminService.getSymptomTypeList();
        Assert.assertEquals(1, symptomTypeList.size());
    }

    /**
     * Tests addNewDiseaseSymptom(), getDiseaseSymptomList(),
     * getDiseaseSymptomListForDisease() and deleteDiseaseSymptom() methods.
     */
    @Test
    @Transactional
    public void getDiseaseSymptomListTest() {
        //Test getDiseaseSymptomList with no data.
        List<DiseaseSymptomEntity> diseaseSymptomList = adminService.getDiseaseSymptomList();
        Assert.assertNotNull(diseaseSymptomList);
        Assert.assertEquals(0, diseaseSymptomList.size());

        //Test getDiseaseSymptomList with one new row.
        DiseaseSymptomEntityTest entityTest = new DiseaseSymptomEntityTest();
        entityTest.saveEntity(entityTest.createValidEntity(), adminService);
        diseaseSymptomList = adminService.getDiseaseSymptomList();
        Assert.assertEquals(1, diseaseSymptomList.size());

        //Test getDiseaseSymptomListForDisease with correct id.
        DiseaseEntity disease = diseaseSymptomList.get(0).getDisease();
        diseaseSymptomList = adminService.getDiseaseSymptomListForDisease(disease.getId());
        Assert.assertEquals(1, diseaseSymptomList.size());

        //Prepare new disease symptom to add using addNewDiseaseSymptom method
        DiseaseSymptomEntity diseaseSymptom = entityTest.createValidEntity();
        diseaseSymptom.setDisease(disease);
        SymptomEntityTest symptomEntityTest = new SymptomEntityTest();
        SymptomEntity symptom = symptomEntityTest.createValidEntity();
        diseaseSymptom.setSymptom(symptomEntityTest.saveEntity(symptom, adminService));
        disease.setDiseaseSymptom(diseaseSymptom);

        //Test addNewDiseaseSymptom method.
        adminService.addNewDiseaseSymptom(disease);
        diseaseSymptomList = adminService.getDiseaseSymptomList();
        Assert.assertEquals(2, diseaseSymptomList.size());
        
        //Test deleteDiseaseSymptom method.
        adminService.deleteDiseaseSymptom(diseaseSymptomList.get(0));
        diseaseSymptomList = adminService.getDiseaseSymptomListForDisease(disease.getId());
        Assert.assertEquals(1, diseaseSymptomList.size());
        
        //Test getDiseaseSymptomListForDisease with null id.
        diseaseSymptomList = adminService.getDiseaseSymptomListForDisease(null);
        Assert.assertEquals(0, diseaseSymptomList.size());
        
    }

    /**
     * Tests getSymptomList() method.
     */
    @Test
    @Transactional
    public void getSymptomListTest() {
        List<SymptomEntity> symptomList = adminService.getSymptomList();
        Assert.assertNotNull(symptomList);
        Assert.assertEquals(0, symptomList.size());

        SymptomEntityTest entityTest = new SymptomEntityTest();
        entityTest.saveEntity(entityTest.createValidEntity(), adminService);

        symptomList = adminService.getSymptomList();
        Assert.assertEquals(1, symptomList.size());
    }

    /**
     * Tests getTestList() method.
     */
    @Test
    @Transactional
    public void getTestListTest() {
        List<TestEntity> testList = adminService.getTestList();
        Assert.assertNotNull(testList);
        Assert.assertEquals(0, testList.size());

        TestEntityTest entityTest = new TestEntityTest();
        entityTest.saveEntity(entityTest.createValidEntity(), adminService);

        testList = adminService.getTestList();
        Assert.assertEquals(1, testList.size());
    }

}
