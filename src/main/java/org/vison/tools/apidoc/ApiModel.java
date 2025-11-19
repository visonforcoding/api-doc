package org.vison.tools.apidoc;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiModel {
    /**
     * 模型参数列表
     */
    private List<ApiParam> params = new ArrayList<>();

    /**
     * 模型类型
     */
    private String type;

    /**
     * 添加单个参数到模型
     */
    public void addParam(ApiParam param) {
        this.params.add(param);
    }

    /**
     * 批量添加参数到模型
     */
    public void addParams(List<ApiParam> params) {
        this.params.addAll(params);
    }
}
