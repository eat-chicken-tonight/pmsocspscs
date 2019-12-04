package pmsocspsc.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.entity.PmItemInfoRetreatEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName PMSOCSPSC
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 11/30/19 2:40 PM
 * @Version 1.0
 * @Description:参数获取工具类
 **/

public class QueryParamUtils {

    /**
     * 获取查询条件
     * @param params
     * @return
     */
    public static QueryWrapper getParams(Map<String, Object> params,Object obj){

        QueryWrapper ew = new QueryWrapper<>().setEntity(obj);

        params.forEach((k,v)->{
            if (!(k.equals("page")||k.equals("limit")))
            System.out.println(k+":"+v);
        });

        return null;
    }

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("page",1);
//        map.put("limit",100);
//        map.put("itemInfoStatus",1);
//        getParams(map,new PmItemInfoRetreatEntity());
        Object a = null;
        System.out.println(a.toString());
    }
}
