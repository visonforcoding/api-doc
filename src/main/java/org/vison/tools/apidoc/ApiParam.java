package org.vison.tools.apidoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * 嵌套字段列表
     * 如果字段是复杂对象类型，可以包含嵌套的字段信息
     */
    private List<ApiParam> nestedFields = new ArrayList<>();


}
