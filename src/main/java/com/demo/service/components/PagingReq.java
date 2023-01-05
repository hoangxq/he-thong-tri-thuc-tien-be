package com.demo.service.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;

@Data
public class PagingReq {

    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_NUM = 1;
    @ApiParam(value = "Size of response's pageData. Minimum value is 1. Default is 10")
    @ApiModelProperty(value = "pageSize")
    @Min(1)
    protected Integer pageSize = DEFAULT_PAGE_SIZE;
    @ApiParam(value = "Number of the page. Minimum is 1. Default is 1.")
    @ApiModelProperty(value = "pageNum. Start from 0")
    @Min(1)
    protected Integer pageNum = DEFAULT_PAGE_NUM;

    @JsonIgnore
    @ApiParam(hidden = true)
    @ApiModelProperty(hidden = true)
    public Pageable makePageable() {
        // Pageable is 0 base, PageRequest is 1 base
        return PageRequest.of(getPageNum() - 1, getPageSize());
    }
}
