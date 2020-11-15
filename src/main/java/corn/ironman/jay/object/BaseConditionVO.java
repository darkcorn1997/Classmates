package corn.ironman.jay.object;


/**基础值对象(basic value Object)**/

public class BaseConditionVO {
    private int pageNum; //当前页码
    private int pageSize; //当前页码行数

    public BaseConditionVO(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
