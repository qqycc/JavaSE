package com.qqy.jdbc.template;

import java.time.LocalDateTime;

/**
 * 包装（关联）数据库的记录（查询的结果）
 * Author: qqy
 */
public class MemoGroup {
    private Integer id;
    private String name;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

