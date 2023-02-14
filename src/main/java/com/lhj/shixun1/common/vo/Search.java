package com.lhj.shixun1.common.vo;

import lombok.Data;

/**
 * @description: Search
 * @program: shixun1
 * @date: 2020-12-29 15:48
 */
@Data
public class Search {
    private int currentPage;
    private int pageSize;
    private String sort;
    private String direction;
    private String keyword;

    public void initSearch() {
        if (currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == 0) {
            pageSize = 5;
        }
    }
}
