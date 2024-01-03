package com.cao.pms.part2.service.Impl;

import com.cao.pms.part2.dao.OlderDao;
import com.cao.pms.part2.pojo.Older;
import com.cao.pms.part2.service.OlderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OlderServiceImpl implements OlderService {

    @Autowired
    private OlderDao olderdao;
    public List<Older> selectOlder(){return olderdao.selectOlder();};

    @Override
    public void addOlder(Older old) {
        olderdao.addOlder(old);
    }

    @Override
    public void deleteOlder(String teleph) {
        olderdao.deleteOlder(teleph);
    }

    @Override
    public void updateOlder(Older old) {
        olderdao.updateOlder(old);
    }

    @Override
    public Older selectaOlder(String teleph){
        return olderdao.selectaOlder(teleph);
    };
}
