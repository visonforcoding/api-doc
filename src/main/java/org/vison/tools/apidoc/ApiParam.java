package org.vison.tools.apidoc;

import lombok.Data;

@Data
public class ApiParam {
    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段类型
     */
    private String fullType;

    /**
     * 简单类型（如String、Integer等）
     */
    private String simpleType;

}
