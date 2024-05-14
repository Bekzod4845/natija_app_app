package com.ompany.dto.channel;

import java.util.List;


public class ChannelResponse {
    private List<ChannelDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
