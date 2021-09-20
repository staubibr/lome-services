package com.models.lib.lom.services.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.models.lib.lom.components.ZipFile;
import com.models.lib.lom.components.services.Dao;
import com.models.lib.lom.components.services.Service;
import com.models.lib.lom.components.services.Query.Comparator;
import com.models.lib.lom.services.contributors.ContributorsService;
import com.models.lib.lom.services.contributors.ContributorsTable;
import com.models.lib.lom.services.file_types.FileTypesService;
import com.models.lib.lom.services.file_types.FileTypesTable;

@Repository
public class FilesService extends Service<Files> {

	@Value("${app.folders.files}")
	private String FOLDER;

	@Autowired
    private FileTypesService sFileTypes;

	@Autowired
    private ContributorsService sContributors;

	@Autowired
	public FilesService(Dao<Files> dao) {
		super(dao);
	}
	
	@Override
	public void getComplexEntity(Files e) {
		e.setFile_type(sFileTypes.selectOne(FileTypesTable.colId, Comparator.eq, e.getFile_type_id()));
		e.setLast_author(sContributors.selectOne(ContributorsTable.colId, Comparator.eq, e.getLast_author_id()));
	}
	
    public byte[] zip(List<Files> entities, Boolean hierarchy) throws IOException {
        ZipFile zf = new ZipFile().Open();
        
        for (int i = 0; i < entities.size(); i++) {
        	Files e = entities.get(i);
        	File source = Paths.get(this.FOLDER, e.getServerPath()).toFile();

        	String target = hierarchy ? Paths.get(e.getPath(), e.getName()).toString() : e.getName();
        	
    		zf.WriteFull(target, source);
        }
       
        zf.Close();
        
        return zf.toByteArray();
    }
}
