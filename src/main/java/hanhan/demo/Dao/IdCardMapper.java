package hanhan.demo.Dao;

import hanhan.demo.Entity.IdCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IdCardMapper {
    @Select("SELECT * FROM idcard WHERE i_code = #{code}")
    List<IdCard> FindByCode(@Param("code") String code);
}
