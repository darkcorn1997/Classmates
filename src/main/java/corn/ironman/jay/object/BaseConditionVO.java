package corn.ironman.jay.object;


/**基础值对象(basic value Object)
 * 对于一个WEB页面将整个页面的属性封装成一个对象,然后用一个VO对象在控制层与视图层进行传输交换
 * 通过这个对象对前端提交的查询条件和mybatis中的参数进行关联**/

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
