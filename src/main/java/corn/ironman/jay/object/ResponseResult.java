package corn.ironman.jay.object;


import java.util.HashMap;
import java.util.Map;


/**封装统一的页面响应结果返回格式**/
public class ResponseResult {
    private final boolean SUCCESS_STATUS = true;
    private final Map<String, Object> response = new HashMap<>();

    public Map<String, Object> error() {
        response.put("error", !SUCCESS_STATUS);
        return response;
    }

    public Map<String, Object> success() {
        response.put("success", SUCCESS_STATUS);
        return response;
    }

    public Map<String, Object> error(String msg) {
        response.put("error", !SUCCESS_STATUS);
        response.put("msg", msg);
        return response;
    }

    public Map<String, Object> success(String msg) {
        response.put("success", SUCCESS_STATUS);
        response.put("msg", msg);
        return response;
    }

    public Map<String, Object> successWithPath(String path) {
        response.put("success", SUCCESS_STATUS);
        response.put("portrait_path", path);
        return response;
    }
}
