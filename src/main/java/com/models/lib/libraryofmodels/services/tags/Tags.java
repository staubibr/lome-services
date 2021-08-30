package com.models.lib.libraryofmodels.services.tags;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Tags {

    private Long id;
    private String value;
}