package com.chinasoft.demo.service;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.chinasoft.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public List<Map<String, Object>> PowerChange(List<Map<String, Object>> list) {
        Map<Integer, String> data = new HashMap<>();
        data.put(0, "管理员管理");
        data.put(1, "楼栋管理");
        data.put(2, "房间管理");
        data.put(3, "业主管理");
        data.put(4, "业主成员");
        data.put(5, "收费项目");
        data.put(6, "业主缴费");
        data.put(7, "物资类别");
        data.put(8, "物资设备");
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> dataMap = list.get(i);
            String str = (String) dataMap.get("roleResource");
            String res = "";
            for (int j = 0; j < str.length(); j++) {
                int n = str.charAt(j) - 48;
                res += data.get(n);
                if (j != str.length()-1)
                    res += '-';
            }
            dataMap.remove("roleResource");
            dataMap.put("roleResource", res);
        }

        return list;
    }

    public String roleAdd(Map<String, Object> map, HttpSession session) {
        int a = adminMapper.roleAdd(map);
        session.setAttribute("roleAdd", map);

        return "redirect:/roleList";
    }

    public String roleList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = adminMapper.roleList(map);
        session.setAttribute("roleList", list);

        return "role/roleList";
    }

    public int roleDelete(List<Integer> list) {

        return adminMapper.roleDelete(list);
    }

    public String powerDetails(Map<String, Object> map, HttpSession session) {
        List<Map<String, Object>> list = adminMapper.powerDetails(map);
        session.setAttribute("powerDetails", list);

        return "redirect:/powerDetails";
    }

    public String powerList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = adminMapper.powerList(map);
        session.setAttribute("powerList", list);

        return "redirect:/powerList";
    }

    public String rolePowerList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = adminMapper.rolePowerList(map);
        list = PowerChange(list);
        session.setAttribute("rolePowerList", list);

        return "redirect:/rolePowerList";
    }

    public String userList(Map<String, Object> map, HttpSession session) {
        List<Map<String, Object>> list = adminMapper.userList(map);
        session.setAttribute("userList", list);

        return "redirect:/userList";
    }

    public String userUpdate(Map<String, Object> map, HttpSession session) {
        int a = adminMapper.userUpdate(map);
        session.setAttribute("userUpdate", map);

        return "redirect:/userList";
    }

    public int userDelete(List<Integer> list) {

        return adminMapper.userDelete(list);
    }

    public String backup(Map<String, Object> map, HttpSession session) {
        List<Map<String, Object>> list = adminMapper.backup(map);
        session.setAttribute("backup", list);

        return "redirect:/backup";
    }

    public int deleteRolePowerByIds(List<Integer> list) {

        return adminMapper.deleteRolePowerByIds(list);
    }

    public String powerUpdate(Map<String, Object> map, HttpSession session) {
        Map<String, Object> list = adminMapper.powerUpdate(map);
        session.setAttribute("powerUpdate", list);

        return "redirect:/powerUpdate";
    }

    public String roleUpdate(Map<String, Object> map, HttpSession session) {
        int a = adminMapper.roleUpdate(map);
        session.setAttribute("roleUpdate", map);

        return "redirect:/roleList";
    }

    public Map<String, Object> mapChange(Map<String, Object> map) {
        Map<String, String> data = new HashMap<>();
        data.put("管理员管理", "0");
        data.put("楼栋管理", "1");
        data.put("房间管理", "2");
        data.put("业主管理", "3");
        data.put("业主成员", "4");
        data.put("收费项目", "5");
        data.put("业主缴费", "6");
        data.put("物资类别", "7");
        data.put("物资设备", "8");
        String []str = map.get("roleResource").toString().split("-");
        String res = "";
        for (int i = 0; i < str.length; i++) {
            res += data.get(str[i]);
        }
        map.remove("roleResource");
        map.put("roleResource", res);
        return map;
    }

    public String rolePowerAdd(Map<String, Object> map, HttpSession session) {
        int a = adminMapper.rolePowerAdd(map);
        session.setAttribute("rolePowerAdd", map);

        return "redirect:/rolePowerList";
    }

    public String rolePowerUpdate(Map<String, Object> map, HttpSession session) {
        int a = adminMapper.rolePowerUpdate(map);
        session.setAttribute("rolePowerUpdate", map);

        return "redirect:/welcome";
    }

    public int rolePowerDelete(List<Integer> list) {

        return adminMapper.rolePowerDelete(list);
    }
}
