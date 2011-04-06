package com.form.base;

/**
 * Page Object
 */
public class Page {
    public static final int FIRST_PAGE = 1;

    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * items for per page
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * total page count
     */
    private int pages;

    /**
     * start  record
     */
    private int startRecord;
    /**
     * default current page
     */
    private int currentPage = 1;
    /**
     * items count
     */
    private int records;

    public Page() {
        this(FIRST_PAGE, DEFAULT_PAGE_SIZE);
    }

    public Page(int pageSize) {
        this(FIRST_PAGE, pageSize);
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Page(int currentPage, int pageSize, int records) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.records = records;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isFirstPage() {
        return currentPage == 1;
    }

    public boolean isLastPage() {
        return currentPage == pages;
    }

    public int getStartRecord() {
        return (currentPage - 1) * pageSize;
    }

    /**
     * @return the records
     */
    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
        int n = records % pageSize;
        if (n > 0)
            pages = records / pageSize + 1;
        else
            pages = records / pageSize;
        if (currentPage < FIRST_PAGE)
            currentPage = FIRST_PAGE;
        if (pages > 0 && currentPage > pages)
            currentPage = pages;
    }

    public int getNextPage() {
        int next = isLastPage() ? pages : currentPage + 1;
        currentPage = next;
        return next;
    }

    public int getPreviousPage() {
        int previous = isFirstPage() ? 1 : currentPage - 1;
        currentPage = previous;
        return previous;
    }

    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }
}
