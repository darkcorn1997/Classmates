package corn.ironman.jay.dao;

import java.io.Serializable;
import java.util.List;

/**通用Mapper接口**/

public interface BaseMapper<T, ID> extends Serializable { //继承序列化接口

    int insert(T t);

    int insertBySelective(T t);

    T selectByPrimaryKey(ID id);

    List<T> selectBySelective(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKeyWithBLOBs(T t);

    int updateByPrimaryKey(T t);

    int deleteByPrimaryKey(ID[] ids);
}
