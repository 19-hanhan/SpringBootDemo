package hanhan.demo.Dao;

import hanhan.demo.Entity.BankCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankCardMapper {
    BankCard FindByCode(@Param("code") String code);

    List<BankCard> FindByUserId(@Param("userId") String userId);
}
