package org.vison.tools.apidoc;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vison.framework.doc.web.ApiInfo;
import org.vison.framework.doc.web.TypeFieldResolver;

import java.lang.reflect.Method;
import java.util.List;

public class MethodApiParseTest {

    @Data
    static class Result<T> {
        private int code;
        private String message;
        public T data;
    }

    @Data
    static class User {
        private String name;
        private int age;
    }

    @Data
    static class Page<T>{
        private List<T> list;
    }

    class TestController {

        // 嵌套参数化类型
        public Result<Page<User>> list() {
            return null;
        }

        public User getUser() {
            return null;
        }
    }

    // 测试嵌套参数化类型返回值解析
    @Test
    void testNestedParameterizationTypes() throws NoSuchMethodException {
        Method listMethod = TestController.class.getMethod("list");
        ApiModel apiModel = TypeFieldResolver.resolveMethodReturnTypeFields(listMethod);
    }

    @Test
    void testUserType() throws NoSuchMethodException {
        Method getUserMethod = TestController.class.getMethod("getUser");
        ApiModel apiModel = TypeFieldResolver.resolveMethodReturnTypeFields(getUserMethod);
    }

}
