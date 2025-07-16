package org.nageoffer.shortlink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.nageoffer.shortlink.project.dao.entity.LinkStatsTodayDO;
import org.nageoffer.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import org.nageoffer.shortlink.project.service.LinkStatsTodayService;
import org.springframework.stereotype.Service;

@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}

