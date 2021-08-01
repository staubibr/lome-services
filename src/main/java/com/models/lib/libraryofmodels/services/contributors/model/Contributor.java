package com.models.lib.libraryofmodels.services.contributors.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import com.models.lib.libraryofmodels.services.db.Persistable;

@Data
@SuperBuilder
@NoArgsConstructor
public class Contributor implements Persistable {

    private Long id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String email;
    private String affiliation;
    private String creation_date;
}
