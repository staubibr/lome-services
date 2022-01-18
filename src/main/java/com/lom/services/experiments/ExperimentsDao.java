package com.lom.services.experiments;

import org.springframework.stereotype.Repository;

import com.lom.components.services.Dao;

@Repository
public class ExperimentsDao extends Dao<Experiments> {
	public ExperimentsDao(ExperimentsTable table) {
		super(table);
	}
}