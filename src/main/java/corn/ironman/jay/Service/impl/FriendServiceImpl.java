package corn.ironman.jay.Service.impl;

import corn.ironman.jay.Service.FriendService;
import corn.ironman.jay.bean.Friend;
import corn.ironman.jay.dao.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl extends AbstractServiceImpl<Friend, Integer> implements FriendService {
    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    @Override
    public void setBaseMapper() {
        super.setBaseMapper(friendMapper);
    }
}
