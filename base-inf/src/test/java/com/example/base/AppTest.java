package com.example.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testOne() {
        String str = "{\"code\":200,\"response\":{\"cate\":[{\"cate_id\":1018631,\"cate_name\":\"\\u7cbe\\u54c1\\u7537\\u88c5\"},{\"cate_id\":1018841,\"cate_name\":\"\\u65f6\\u5c1a\\u5973\\u88c5\"},{\"cate_id\":1019231,\"cate_name\":\"\\u7bb1\\u5305\\u914d\\u9970\"},{\"cate_id\":1020091,\"cate_name\":\"\\u7f8e\\u5bb9\\u7f8e\\u5986\"},{\"cate_id\":1033531,\"cate_name\":\"\\u98ce\\u60c5\\u978b\\u9774\"},{\"cate_id\":1374967,\"cate_name\":\"\\u98df\\u54c1\\u96f6\\u98df\"},{\"cate_id\":1378147,\"cate_name\":\"\\u6027\\u611f\\u5185\\u8863\"},{\"cate_id\":2030000,\"cate_name\":\"\\u6bcd\\u5a74\\u7ae5\\u88c5\"},{\"cate_id\":2080000,\"cate_name\":\"\\u6570\\u7801\\u7535\\u5668\"},{\"cate_id\":2090000,\"cate_name\":\"\\u5bb6\\u5c45\\u65e5\\u7528\"},{\"cate_id\":2100000,\"cate_name\":\"\\u6c7d\\u914d\\u6237\\u5916\"}],\"message\":\"\\u83b7\\u53d6\\u6210\\u529f\",\"error\":false}}";
        JSONObject strJson = JSONObject.parseObject(str);
        JSONObject response = strJson.getJSONObject("response");
        JSONArray cateJsonArray = response.getJSONArray("cate");
        cateJsonArray.stream().forEach(cate-> System.out.println(cate));
        System.out.println(cateJsonArray.size());

        //        Map<String, Object> map = JSONObject.parseObject(str, Map.class);
//        System.out.println(map.get("response"));
//        JSONArray jsonArray = JSONObject.parseArray(map.get("response").toString());
//        System.out.println(jsonArray.size());
    }

}
