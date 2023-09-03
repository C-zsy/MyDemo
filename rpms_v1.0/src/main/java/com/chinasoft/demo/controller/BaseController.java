package com.chinasoft.demo.controller;

import freemarker.template.utility.StringUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

public class BaseController {
    public static Map<String, Object> getParamMap(HttpServletRequest request) {
        Map<String, Object> mp = new HashMap<>();
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Object v = map.get(key)[0];
            mp.put(key, v);
        }

        return mp;
    }

//    public List<Integer> getDeleteData(String ids) {
//        List<Integer> list = new ArrayList<>();
//        ids = ids.replace(",", "");
//        int start = 0;
//        for (int end = 4; end <= ids.length(); end += 4) {
//            String str = ids.substring(start, end);
//            list.add(Integer.parseInt(str));
//            start = end;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        return list;
//    }
    public List<Integer> getDeleteData(String ids){
        List<Integer> list = new ArrayList<>();
        String s[] = ids.split(",");
        for (int i = 0; i < s.length; i++){
            list.add(Integer.parseInt(s[i]));
        }
        return list;
    }

    public ModelAndView getModelAndView(Object obj, String viewName){
        //ArrayList arrayList = new ArrayList();
        ModelAndView m=new ModelAndView();
        if(obj instanceof List){
            m.addObject("list",obj);
        }
        m.setViewName(viewName);
        return m;
    }

    public Map<String, Object> getPageBean(Map<String,Object> dataMap, int totalCount){
        //分页思路分析首先分页需要4个重要的参数
        //pageIndex当前页  pageSize每页最大条数  totalCount 总的数量 totalPage总的页数
        //Map<String,Object> dataMap=getParamMap(request);//什么都没有，也有可能有条件或者是分页的参数
        int pageIndex=Integer.parseInt(dataMap.get("pageIndex").toString());//得到当前页
        int pageSize=Integer.parseInt(dataMap.get("pageSize").toString());//得到每页的最大条数
        int totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;//总的页数
        int start=(pageIndex-1)*pageSize;//得到索引号
        dataMap.put("totalCount",totalCount);
        dataMap.put("pageIndex",pageIndex);
        dataMap.put("pageSize",pageSize);
        dataMap.put("totalPage",totalPage);
        dataMap.put("start",start);
        return dataMap;
    }

    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename(); //得到文件的名称
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf(".")); //更改名字，以防文件覆盖
        String filePath = "D:/Summer_Training/upload/" + newFileName;
        InputStream in = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath);
            in = file.getInputStream();
            IOUtils.copy(in, out);
        } catch (Exception e) {

        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {

            }
        }

        return "static/" + newFileName;
    }
}
