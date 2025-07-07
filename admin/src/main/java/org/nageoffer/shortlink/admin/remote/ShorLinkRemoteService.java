package org.nageoffer.shortlink.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkCreateRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkGroupCountQueryRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkPageRespDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短链接远程服务接口
 */
public interface ShorLinkRemoteService {

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求参数
     * @return 短链接创建响应结果
     */
    default Result<ShortLinkCreateRespDTO> createShortLink(ShortLinkCreateReqDTO requestParam){
        String resultBodyStr = HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBodyStr, new TypeReference<>() {
        });
    }


    /**
     * 分页查询短链接
     *
     * @param requestParam 短链接分页请求参数
     * @return 短链接分页响应结果
     */
    default Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid", requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/page", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }


    /**
     * 统计分组下短链接数量
     * @param requestParam
     * @return
     */
    default Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(List<String> requestParam){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);
        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/v1/count", requestMap);
        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }


    /**
     * 修改短链接
     * @param requestParam
     */
    default void updateShortLink(ShortLinkUpdateReqDTO requestParam){
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/v1/update", JSON.toJSONString(requestParam));
    };
}
