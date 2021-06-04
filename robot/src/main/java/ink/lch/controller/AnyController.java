package ink.lch.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 对所有的请求，进行一个接收
 */
@RestController
@RequestMapping("/")
@Slf4j
public class AnyController {

    private final String verification_type = "url_verification";

    /**
     * 所有请求的通道，对不同的飞书反馈请求，进行处理
     *
     * @return
     */
    @RequestMapping()
    public Object accessRequest(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 将请求转化成输入流
            ServletInputStream inputStream = request.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str; // 初始化
            StringBuilder value = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                value.append(str);
            }
            log.info(value.toString());
            JSONObject jsonObject = JSONObject.parseObject(value.toString());
            if (verification_type.equals(jsonObject.get("type"))) {
                map.put("challenge", jsonObject.get("challenge"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
