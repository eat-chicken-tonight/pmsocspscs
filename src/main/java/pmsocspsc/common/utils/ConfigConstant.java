/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package pmsocspsc.common.utils;

/**
 * 系统参数相关Key
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ConfigConstant {
    /**
     * 云存储配置KEY
     */
    public final static String CLOUD_STORAGE_CONFIG_KEY = "CLOUD_STORAGE_CONFIG_KEY";
    /**
     * 文件保存路径
     */
    public final static String UPLOAD_FILE_SAVE_PATH = "/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target";
    /**
     * 审核状态
     */
    //未提交
    public static final int NOT_SUBMIT = 0;
    //待审核
    public static final int WAITER_CHECK = 1;
    //通过
    public static final int PASS = 2;
    //未通过
    public static final int NOT_PASS = 3;
}
