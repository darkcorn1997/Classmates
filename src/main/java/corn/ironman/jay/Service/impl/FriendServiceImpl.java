package corn.ironman.jay.Service.impl;

import com.github.pagehelper.PageInfo;
import corn.ironman.jay.Service.FriendService;
import corn.ironman.jay.bean.Friend;
import corn.ironman.jay.dao.FriendMapper;
import corn.ironman.jay.object.BaseConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // ？
public class FriendServiceImpl extends AbstractServiceImpl<Friend, Integer> implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    //the method must be implemented
    //注:这句必须要加上,不然会报空指针异常,因为在实际掉用的时候不是BaseMapper调用,而是friendMapper
    @Autowired
    @Override
    public void setBaseMapper() {
        super.setBaseMapper(friendMapper);
    }

    @Override
    public int insertBySelective(Friend friend) {
        return super.insertBySelective(friend);
    }

    @Override
    public List<Friend> selectBySelective(Friend friend) {
        return super.selectBySelective(friend);
    }

    @Override
    public int updateByPrimaryKey(Friend friend) {
        return super.updateByPrimaryKey(friend);
    }

    @Override
    public int deleteByPrimaryKey(Integer[] integers) {
        return super.deleteByPrimaryKey(integers);
    }

    @Override
    public PageInfo<Friend> selectForPage(Friend friend, BaseConditionVO baseConditionVO) {
        return super.selectForPage(friend, baseConditionVO);
    }
}
