package com.coedeshuai.community.community.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：codeshuai
 * @date ：Created in 2020/6/27 0:24
 */
public class PaginationDTO {
    private List<QuestionDTO> questions;
    //  是否有前后按钮
    private boolean showPrevious;
    private boolean showNext;
    private boolean showFristPage;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        this.page = page;
//把当前页码放在pages里面
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
//               往前是头部插入，往后是尾部插入
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }


//      是否展示上一页
//      除了第一页，其余页码是没有上一页的
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
//      是否展示下一页
//      除了最后一页，其余页码是没有下一页的
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

//        是否展示第一页
        if (pages.contains(1)) {
            showFristPage = false;
        } else {
            showFristPage = true;
        }
//       是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }

    @Override
    public String toString() {
        return "PaginationDTO{" +
                "questions=" + questions +
                ", showPrevious=" + showPrevious +
                ", showNext=" + showNext +
                ", showFristPage=" + showFristPage +
                ", showEndPage=" + showEndPage +
                ", page=" + page +
                ", pages=" + pages +
                ", totalPage=" + totalPage +
                '}';
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowFristPage() {
        return showFristPage;
    }

    public void setShowFristPage(boolean showFristPage) {
        this.showFristPage = showFristPage;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
