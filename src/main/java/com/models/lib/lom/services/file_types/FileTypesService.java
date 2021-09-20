package com.models.lib.lom.services.file_types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.models.lib.lom.components.services.Dao;
import com.models.lib.lom.components.services.Service;

@Repository
public class FileTypesService extends Service<FileTypes> {

	@Autowired
	public FileTypesService(Dao<FileTypes> dao) {
		super(dao);
	}

	@Override
	public void getComplexEntity(FileTypes entity) {
		
	}
}
