package com.demo.service.components;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PagingRes {

    private Pagination pagination;
    private Object data;

    protected PagingRes(Page<? extends Object> page) {
        this.data = page.getContent();
        this.pagination = Pagination.builder()
                .page(page.getNumber() + 1)
                .totalPage(page.getTotalPages())
                .totalRecord(page.getTotalElements())
                .build();
    }

    public static PagingRes of(Page<? extends Object> page) {
        return new PagingRes(page);
    }

    @Data
    @Builder
    public static class Pagination {
        private int page;
        private long totalPage;
        private long totalRecord;
    }

}
