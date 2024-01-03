package com.cao.pms.part2.dao;

import com.cao.pms.part2.pojo.Older;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OlderDao {
    public List<Older> selectOlder();

    public Older selectaOlder(String teleph);

    public void addOlder(Older old);

    public void deleteOlder(String teleph);

    public void updateOlder(Older old);


}
