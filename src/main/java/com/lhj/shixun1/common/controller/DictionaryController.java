package com.lhj.shixun1.common.controller;

import com.lhj.shixun1.common.vo.ImageType;
import com.lhj.shixun1.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/common")
public class DictionaryController {
    public static Map<String, Class> map = new HashMap<>(){
        {
            put("imageType", ImageType.class);
            put("ResultCode", Result.ResultCode.class);
        }
    };
//    static {
//        map.put("imageType", ImageType.class);
//        map.put("ResultCode", Result.ResultCode.class);
//    }
    @GetMapping("/dictionary/{key}")
    public List<Object> getDictionary(@PathVariable String key) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = map.get(key);
        if (clazz != null) {
            Method method = clazz.getDeclaredMethod("values");
            Object[] eumList =(Object[]) method.invoke(null);
            return Arrays.asList(eumList);
        }
        return null;
    }
}
