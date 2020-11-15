package corn.ironman.jay.Service;

import com.github.pagehelper.PageInfo;
import corn.ironman.jay.object.BaseConditionVO;

import java.io.Serializable;
import java.util.List;

/**通用Service接口**/

public interface BaseService<T, ID> extends Serializable {

    void setBaseMapper();

    int insert(T t);

    int insertBySelective(T t);

    T selectByPrimaryKey(ID id);

    List<T> selectBySelective(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKeyWithBLOBs(T t);

    int updateByPrimaryKey(T t);

    int deleteByPrimaryKey(ID[] ids);

    PageInfo<T> selectForPage(T t, BaseConditionVO baseConditionVO);
}
