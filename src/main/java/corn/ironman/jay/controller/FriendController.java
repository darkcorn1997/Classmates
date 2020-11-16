package corn.ironman.jay.controller;


import com.github.pagehelper.PageInfo;
import corn.ironman.jay.Service.FriendService;
import corn.ironman.jay.bean.Friend;
import corn.ironman.jay.object.BaseConditionVO;
import corn.ironman.jay.object.PageResult;
import corn.ironman.jay.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**好友列表信息页管理**/
@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/goMainView")
    public ModelAndView goMainView() {
        return ResultUtil.view("main");
    }

    @GetMapping("/goFriendListView")
    public ModelAndView goFriendListView() {
        return ResultUtil.view("friendList");
    }

    /**
     * @description: 分页查询:根据好友姓名获取指定/所有好友列表信息
     * @param: pageNum 当前页码
     * @param: pageSize 列表行数
     * @param: username 好友姓名
     * @return: PageResult
     */
    @PostMapping("/getFriendListView")
    @ResponseBody
    public PageResult getFriendList(String username, Integer pageNum, Integer pageSize) {
        // 获取封装查询结果
        PageInfo<Friend> pageInfo = friendService.selectForPage(new Friend(username),
                new BaseConditionVO(pageNum, pageSize));
        // 返回分页数据
        return ResultUtil.tablePage(pageInfo);
    }

    /**
     * @description: 添加好友信息
     * @param: friend 好友信息
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/addFriend")
    @ResponseBody
    public Map<String, Object> addFriend(Friend friend) {
        return friendService.insertBySelective(friend) > 0 ? ResultUtil.success("添加成功") :
                ResultUtil.error("添加失败:服务器端发生异常!");
    }

    /**
     * @description: 更新好友信息
     * @param: friend 好友信息
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/editFriend")
    @ResponseBody
    public Map<String, Object> editFriend(Friend friend) {
        return friendService.updateByPrimaryKey(friend) > 0 ? ResultUtil.success("更新成功") :
                ResultUtil.error("更新失败:服务器端发生异常!");
    }

    /**
     * @description: 删除好友信息
     * @param: ids
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @PostMapping("/deleteFriend")
    @ResponseBody
    public Map<String, Object> deleteFriend(@RequestParam(value = "ids[]") Integer[] ids) {
        return friendService.deleteByPrimaryKey(ids) > 0 ? ResultUtil.success("更新成功") :
                ResultUtil.error("删除失败:服务器端发生异常!");
    }
}
