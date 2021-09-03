package com.models.lib.lom.unused;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Pagination {

    private Integer currentPage;
    private Integer count;
    private Integer pageSize;
    private Integer totalPages;
}