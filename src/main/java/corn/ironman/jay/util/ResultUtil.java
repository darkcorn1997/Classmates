package corn.ironman.jay.util;

import com.github.pagehelper.PageInfo;
import corn.ironman.jay.object.PageResult;
import corn.ironman.jay.object.ResponseResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**工具类 返回结果统一格式处理**/
public class ResultUtil {

    public static ModelAndView view(String view) {return new ModelAndView(view);}

    public static ModelAndView view(String view, Map<String, Object> map) {return new ModelAndView(view, map);}

    public static ModelAndView redirect(String view) {return new ModelAndView("redirect:" + view);}

    public static Map<String, Object> error() {
        return new ResponseResult().error();
    }

    public static Map<String, Object> success() {
        return new ResponseResult().success();
    }

    public static Map<String, Object> error(String msg) {
        return new ResponseResult().error(msg);
    }

    public static Map<String, Object> success(String msg) {
        return new ResponseResult().success(msg);
    }

    public static Map<String, Object> successWithPath(String path) {
        return new ResponseResult().successWithPath(path);
    }

    public static PageResult tablePage(Long total, List<?> rows) {
        return new PageResult(total, rows);
    }

    public static <T> PageResult tablePage(PageInfo<T> pageInfo) {
        if (pageInfo == null) {
            return new PageResult(0L, new ArrayList<>()); //表示长整形0
        }
        return tablePage(pageInfo.getTotal(), pageInfo.getList());
    }
}
