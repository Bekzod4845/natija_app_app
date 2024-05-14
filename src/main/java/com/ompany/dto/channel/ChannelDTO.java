package com.ompany.dto.channel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDTO {
    private int id;
    private String name;
    private String tgId;
    private LocalDate createdDate;
}
