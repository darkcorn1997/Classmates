package corn.ironman.jay.dao;


import corn.ironman.jay.bean.Friend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendMapper extends BaseMapper<Friend, Integer> {

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
