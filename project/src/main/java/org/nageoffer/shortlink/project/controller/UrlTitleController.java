package org.nageoffer.shortlink.project.controller;

import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.project.common.convention.result.Result;
import org.nageoffer.shortlink.project.common.convention.result.Results;
import org.nageoffer.shortlink.project.service.UrlTitleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL标题控制器
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    private final UrlTitleService urlTitleService;
    /**
     * 获取URL标题
     */
    @GetMapping("/api/shor-link/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return Results.success(urlTitleService.getTitleByUrl(url));
    }
}
