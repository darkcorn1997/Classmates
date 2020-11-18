package corn.ironman.jay.object;


import java.util.List;


/**封装统一的分页结果返回格式**/
public class PageResult {
    private Long total;
    private List<?> rows;

    public PageResult() {}
    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public List<?> getRows() {
        return rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
