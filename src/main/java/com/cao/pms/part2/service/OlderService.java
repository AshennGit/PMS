package com.cao.pms.part2.service;

import com.cao.pms.part2.pojo.Older;

import java.util.List;

public interface OlderService {
    public List<Older> selectOlder();

    public void addOlder(Older old);

    public void deleteOlder(String teleph);

    public void updateOlder(Older old);

    public Older selectaOlder(String teleph);
}
