package org.vison.tools.apidoc;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        // 断言返回的ApiParam列表包含预期的字段,第一层 Result<T> 包含 code, message, data
        Assertions.assertEquals(3, apiModel.getParams().size());
        Assertions.assertEquals("code", apiModel.getParams().get(0).getName());
        Assertions.assertEquals("message", apiModel.getParams().get(1).getName());
        Assertions.assertEquals("data", apiModel.getParams().get(2).getName());
        // 第二层 Page<T> 包含 list
        Assertions.assertEquals(1, apiModel.getParams().get(2).getNestedFields().size());
        Assertions.assertEquals("list", apiModel.getParams().get(2).getNestedFields().get(0).getName());
        // 第三层 User 包含 name, age
        List<ApiParam> userFields = apiModel.getParams().get(2).getNestedFields().get(0).getNestedFields();
        Assertions.assertEquals(2, userFields.size());
        Assertions.assertEquals("name", userFields.get(0).getName());
        Assertions.assertEquals("age", userFields.get(1).getName());
    }

    @Test
    void testUserType() throws NoSuchMethodException {
        Method getUserMethod = MethodApiParseTest.TestController.class.getMethod("getUser");
        ApiModel apiModel = TypeFieldResolver.resolveMethodReturnTypeFields(getUserMethod);
    }

}
