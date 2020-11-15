package corn.ironman.jay.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import corn.ironman.jay.Service.BaseService;
import corn.ironman.jay.dao.BaseMapper;
import corn.ironman.jay.object.BaseConditionVO;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractServiceImpl<T, ID> implements BaseService<T, ID>, Serializable {

    private BaseMapper<T, ID> baseMapper;

    //初始化baseMapper
    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int insertBySelective(T t) {
        return baseMapper.insertBySelective(t);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectBySelective(T t) {
        return baseMapper.selectBySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T t) {
        return baseMapper.updateByPrimaryKeyWithBLOBs(t);
    }

    @Override
    public int deleteByPrimaryKey(ID[] ids) {
        return baseMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public PageInfo<T> selectForPage(T t, BaseConditionVO baseConditionVO) {
        PageHelper.startPage(baseConditionVO.getPageNum(), baseConditionVO.getPageSize()); //设置每夜的记录数
        List<T> list = baseMapper.selectBySelective(t); //获取列表信息
        return new PageInfo<>(list);
    }
}
