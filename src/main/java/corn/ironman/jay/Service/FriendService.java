package corn.ironman.jay.Service;

import com.github.pagehelper.PageInfo;
import corn.ironman.jay.bean.Friend;
import corn.ironman.jay.object.BaseConditionVO;

import java.util.List;

public interface FriendService extends BaseService<Friend, Integer> {

    @Override
    void setBaseMapper();

    //添加好友信息
    @Override
    int insertBySelective(Friend friend);

    //选择性查询好友信息
    @Override
    List<Friend> selectBySelective(Friend friend);

    //更新好友信息
    @Override
    int updateByPrimaryKey(Friend friend);

    //删除好友信息
    @Override
    int deleteByPrimaryKey(Integer[] ids);

    @Override
    PageInfo<Friend> selectForPage(Friend friend, BaseConditionVO baseConditionVO);
}
