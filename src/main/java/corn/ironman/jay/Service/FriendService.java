package corn.ironman.jay.Service;

import corn.ironman.jay.bean.Friend;

import java.util.List;

public interface FriendService extends BaseService<Friend, Integer> {
    
    //设置baseMapper
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
}
