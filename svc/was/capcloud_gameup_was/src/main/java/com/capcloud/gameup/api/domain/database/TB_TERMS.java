package com.capcloud.gameup.api.domain.database;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TB_TERMS {
    private long termsId;
    private int termsSeq;
    private String termsVersion;
    private int termsIsRequired;
    private String termsTitle;
    private String termsContent;
    private String termsCreatedDate;
}
