package com.models.lib.lom.services.experiments;

import org.springframework.stereotype.Repository;

import com.models.lib.lom.services.db.Dao;

@Repository
public class ExperimentsDao extends Dao<Experiments> {
	public ExperimentsDao(ExperimentsTable table) {
		super(table);
	}
	
	@Override
    public void setRelated(Experiments entity) {
    	
    }
}
