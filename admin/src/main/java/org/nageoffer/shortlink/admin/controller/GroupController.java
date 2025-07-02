package org.nageoffer.shortlink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.common.convention.result.Results;
import org.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.nageoffer.shortlink.admin.dto.resq.ShortLinkGroupRespDTO;
import org.nageoffer.shortlink.admin.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分组管理控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }

    /**
     * 查询所有短链接分组
     * @return
     */

    @GetMapping("/api/short-link/admin/v1/group/" )
    public Result<List<ShortLinkGroupRespDTO>> listGroups() {
        List<ShortLinkGroupRespDTO> groups = groupService.listGroup();
        return Results.success(groups);
    }

    /**
     * 更新短链接分组
     * @return
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接分组
     * @param gid
     * @return
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 分组排序
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/group/sort")
    public Result<Void> sortGroup(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam) {
        groupService.sortGroup(requestParam);
        return Results.success();
    }

}
