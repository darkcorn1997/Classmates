package corn.ironman.jay.object;


/**基础值对象(basic value Object)**/

public class BaseConditionVO {
    private int page; //当前页码
    private int rows; //当前页码行数

    public BaseConditionVO(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
