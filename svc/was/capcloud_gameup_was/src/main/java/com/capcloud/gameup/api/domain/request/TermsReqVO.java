package com.capcloud.gameup.api.domain.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TermsReqVO {
    private long id;
    private String content;
}
