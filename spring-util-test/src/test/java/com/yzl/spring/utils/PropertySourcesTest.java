package com.yzl.spring.utils;

import org.junit.Test;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * spring中属性占位使用
 * Created by yinzuolong
 */
public class PropertySourcesTest {
    @Test
    public void test() throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("k1", "123");
        map.put("k2", "${k1}");
        map.put("k3", "${k1:8080}");
        map.put("k4", "${kx:8080}");
        map.put("k5", "${kx:k1}");
        map.put("k6", "${kx:${k1}}");
        map.put("k7", "${kx:localhost:123}");
        map.put("k8", "${kx:${ky:8080}}");
        map.put("中文","中国");
        map.put("杭州","${中文}-杭州");
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addFirst(new MapPropertySource("t1", map));

        PropertySourcesPropertyResolver p = new PropertySourcesPropertyResolver(propertySources);
        for (String key : map.keySet()) {
            System.out.println(key + ":" + p.getProperty(key));
        }
    }
}
