package com.hzs.springbootdemo.config.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * 属性配置NeoProperties
 *
 * @author hezhensheng3
 * @date 2020-01-02 16:32
 **/
public class NeoProperties {
    /**
     * 标题
     */
    @Value("${com.neo.title}")
    private String title;

    /**
     * 描述
     */
    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
