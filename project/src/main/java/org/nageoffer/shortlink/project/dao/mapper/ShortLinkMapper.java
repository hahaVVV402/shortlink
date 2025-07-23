package org.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;

/**
 * 链接 Mapper 接口
 * 该接口用于定义与链接相关的数据库操作方法
 */
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {
    /**
     * 短链接访问统计自增
     */
    void incrementStats(@Param("gid") String gid,
                        @Param("fullShortUrl") String fullShortUrl,
                        @Param("totalPv") Integer totalPv,
                        @Param("totalUv") Integer totalUv,
                        @Param("totalUip") Integer totalUip);

    /**
     * 分页统计短链接
     */
    IPage<ShortLinkDO> pageLink(ShortLinkPageReqDTO requestParam);

    /**
     * 分页统计回收站短链接
     */
    IPage<ShortLinkDO> pageRecycleBinLink(ShortLinkRecycleBinPageReqDTO requestParam);

}
