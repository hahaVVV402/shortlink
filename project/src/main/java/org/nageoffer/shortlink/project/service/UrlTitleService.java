package org.nageoffer.shortlink.project.service;

/**
 * URL标题服务接口
 */
public interface UrlTitleService {

    /**
     * 根据URL获取标题
     * @param url
     * @return
     */
    String getTitleByUrl(String url);
}
