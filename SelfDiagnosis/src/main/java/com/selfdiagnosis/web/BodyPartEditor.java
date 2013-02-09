package com.selfdiagnosis.web;

import java.beans.PropertyEditorSupport;

import com.selfdiagnosis.core.dao.BodyPartDAO;
import com.selfdiagnosis.core.entity.BodyPartEntity;

public class BodyPartEditor extends PropertyEditorSupport {
	
	public final BodyPartDAO bodyPartDAO;
	
	public BodyPartEditor(BodyPartDAO bodyPartDAO) {
		this.bodyPartDAO = bodyPartDAO;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		BodyPartEntity bodyPart = (BodyPartEntity)bodyPartDAO.getObject(BodyPartEntity.class, Integer.parseInt(text)); 
		setValue(bodyPart);
	}

}