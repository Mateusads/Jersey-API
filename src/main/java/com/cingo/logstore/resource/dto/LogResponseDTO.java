package com.cingo.logstore.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogResponseDTO {

    private int id;
    private String content;
    private int occurrences;
}
