package com.learn.common;

import lombok.*;

/**
 * @author Owen
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageData {
    /**
     * 总记录数
     */
    @Getter
    private long total;
    /**
     * 总页数
     */
    @Getter
    private long totalPage;
    /**
     * 当前页  mongo在使用该值的时候，记得要减去1
     */
    @Setter
    private Integer pageNo = 1;
    /**
     * 每页显示多少条
     */
    @Setter
    private Integer pageSize = 20;

    /**
     * if isSearchCount = true, total & totalPage will have value;
     * default is false;
     */
    @Getter
    @Setter
    private boolean isSearchCount = false;

    public void setTotal(long total) {
        this.total = total;
        if (pageSize > 0) {
            this.totalPage = (total + pageSize - 1) / pageSize;
        }
    }

    public Integer getPageNo() {
        if (null == this.pageNo || 0 == this.pageNo) {
            pageNo = 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (null == this.pageSize || 0 == this.pageSize) {
            pageSize = 20;
        }
        return pageSize;
    }
}
