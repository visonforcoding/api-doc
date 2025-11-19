package org.vison.tools.apidoc;

import java.lang.reflect.Method;

public class TypeFieldResolver {

    /**
     * 解析方法返回类型的所有字段（支持普通类型、参数化类型、多层嵌套参数化类型）
     * @param method 目标方法（如TestController.class.getMethod("list")）
     * @return 包含所有嵌套字段的ApiParam列表（用List存储，不去重）
     */
    public static ApiModel resolveMethodReturnTypeFields(Method method) {

    }
}
