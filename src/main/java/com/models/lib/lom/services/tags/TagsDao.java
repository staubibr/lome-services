package com.models.lib.lom.services.tags;

import org.springframework.stereotype.Repository;

import com.models.lib.lom.components.services.Dao;

@Repository
public class TagsDao extends Dao<Tags> {
	public TagsDao(TagsTable table) {
		super(table);
	}
}