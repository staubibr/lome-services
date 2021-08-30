package com.models.lib.libraryofmodels.services.tags;

import java.util.List;

import com.models.lib.libraryofmodels.services.db.DbWhereClause;
import com.models.lib.libraryofmodels.services.db.DbWhereClause.Comparator;
import com.models.lib.libraryofmodels.services.db.DbWhereClause.Condition;
import com.models.lib.libraryofmodels.services.tags.TagsTable.TagsDbColumn;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TagsQuery {

    private List<Long> ids;
    private Integer pageSize;
    private Integer pageNumber;
    
    public DbWhereClause ToWhere() {
        DbWhereClause ret = new DbWhereClause(getPageSize(),getPageNumber());
        
        if (getIds() != null) {
            ret.addCondition(new Condition(TagsDbColumn.id, Comparator.in, getIds()));
        }

        ret.setPageNumber(0);
        ret.setOffset(0);
        ret.setPageSize(100);
        
        return ret;
    }
}