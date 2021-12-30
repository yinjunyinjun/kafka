package com.mycompany.kafka.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yinjun on 2019/12/22
 */
public class MapUtil {
    public static final Log logger = LogFactory.getLog(MapUtil.class);

    /**
     * <p>
     * 1、有flag为Y(或y)，则表明parmMap中的key值为必输项，若不存在此key，则直接抛出异常给方法调用方。
     * 2、从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回(可能会含有“”），
     * 若不存在，则返回null，
     * <p>
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    Y表示必输，  其他值 表非必输
     * @return null或parmMap中key值（key值可能为“”字符串）
     */
    public static Object getKeyValues(Map parmMap, String key, String flag) throws Exception {
        //  logger.debug("MapUtil:getKeyValues==>paramMap:" + parmMap + ";key==" + key);
        if (parmMap == null || StringUtils.isEmpty(key)) {
            throw new Exception("参数异常【parmMap及key】，不可为NULL! parmMap=" + parmMap + ";key=" + key);
        }
        if ("Y".equals(flag) || "y".equals(flag)) {
            if ((!parmMap.containsKey(key)) || StringUtils.isEmpty(parmMap.get(key)) || Objects.equals("null", parmMap.get(key))) {
                throw new Exception("必输项【" + key + "】不可为空！");
            } else {
                return parmMap.get(key);
            }
        } else {
            if ((!parmMap.containsKey(key)) || Objects.equals("null", String.valueOf(parmMap.get(key)).toLowerCase())) {
                logger.debug("参数中不含" + key + ",返回null");
                return null;//若查询不到该key，则至为null
                //throw  new ServiceException("50",key+"不存在！");
            } else {
                return parmMap.get(key);
            }
        }
    }

    /**
     * <p>
     * 从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（key值取出的可能为“”字符串），
     * 若不存在，则返回null
     * </p>
     *
     * @param parmMap
     * @param key
     * @return null或parmMap中key的值
     */
    public static Object getKeyValues(Map parmMap, String key) throws Exception {
        return getKeyValues(parmMap, key, null);
    }
//String, Integer, Long, BigDecimal, Date

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（key值取出的可能为“”字符串），
     * 若不存在，则返回null
     * flag为Y时，表明parmMap中该字段为必输项，若不存在该key值，抛出参数异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    是否必输  Y表示必输，  其他值 表非必输
     * @return parmMap中key的值或null
     */
    public static String getKeyStringValues(Map parmMap, String key, String flag) throws Exception {
        Object obj = getKeyValues(parmMap, key, flag);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * flag为Y时，表明parmMap中该字段为必输项，若不存在该key值，抛出参数异常。
     * 将返回的值换成Integer类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    是否必输  Y表示必输，  其他值 表非必输
     * @return null或Integer类型的key值
     */
    public static Integer getKeyIntegerValues(Map parmMap, String key, String flag) throws Exception {
        Object obj = getKeyValues(parmMap, key, flag);
        if (StringUtils.isEmpty(obj)) {
            return null;
        }
        return Integer.parseInt(String.valueOf(obj));
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * flag为Y时，表明parmMap中该字段为必输项，若不存在该key值，抛出参数异常。
     * 将返回的值换成Long类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    是否必输  Y表示必输，  其他值 表非必输
     * @return null或Long类型的key值
     */
    public static Long getKeyLongValues(Map parmMap, String key, String flag) throws Exception {
        Object obj = getKeyValues(parmMap, key, flag);

        if (StringUtils.isEmpty(obj)) {
            return null;
        }
        return Long.parseLong(String.valueOf(obj));
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * flag为Y时，表明parmMap中该字段为必输项，若不存在该key值，抛出参数异常。
     * 将返回的值换成BigDecimal类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    是否必输  Y表示必输，  其他值 表非必输
     * @return null或BigDecimal类型的key值
     */
    public static BigDecimal getKeyBigDecimalValues(Map parmMap, String key, String flag) throws Exception {
        Object obj = getKeyValues(parmMap, key, flag);
        if (StringUtils.isEmpty(obj)) {
            return null;
        }
        return new BigDecimal(String.valueOf(obj));
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * flag为Y时，表明parmMap中该字段为必输项，若不存在该key值，抛出参数异常。
     * 将返回的值换成Date类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @param flag    是否必输  Y表示必输，  其他值 表非必输
     * @return null或Date类型的key值
     */
    public static Date getKeyDateValues(Map parmMap, String key, String flag) throws Exception {
        Object obj = getKeyValues(parmMap, key, flag);
        if (StringUtils.isEmpty(obj)) {
            return null;
        }
        String str = String.valueOf(obj);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(str);

        } catch (Exception e) {
            throw new Exception("日期格式转换失败！");
        }
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（key值取出的可能为“”字符串），
     * 若不存在，则返回null
     * </p>
     *
     * @param parmMap
     * @param key
     * @return parmMap中key的值或null
     */
    public static String getKeyStringValues(Map parmMap, String key) throws Exception {
        return getKeyStringValues(parmMap, key, null);
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * 将返回的值换成Integer类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @return null或Integer类型的key值
     */
    public static Integer getKeyIntegerValues(Map parmMap, String key) throws Exception {
        return getKeyIntegerValues(parmMap, key, null);
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * 将返回的值换成Long类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @return null或Long类型的key值
     */
    public static Long getKeyLongValues(Map parmMap, String key) throws Exception {
        return getKeyLongValues(parmMap, key, null);
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * 将返回的值换成BigDecimal类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @return null或BigDecimal类型的key值
     */
    public static BigDecimal getKeyBigDecimalValues(Map parmMap, String key) throws Exception {
        return getKeyBigDecimalValues(parmMap, key, null);
    }

    /**
     * <p>从参数parmMap中判断key值是否存在，
     * 若存在，取出key值返回（不包含“”字符串），
     * 若不存在或者为“”字符串时，则返回null
     * 将返回的值换成Date类型，若转换失败，则直接抛出错误异常。
     * </p>
     *
     * @param parmMap
     * @param key
     * @return null或Date类型的key值
     */
    public static Date getKeyDateValues(Map parmMap, String key) throws Exception {
        return getKeyDateValues(parmMap, key, null);
    }

    /**
     * <p>
     * <b>不推荐使用该方法</b>
     * 从map中获取key对应的值，若key对应的值与参数value相等，则返回Y，否则，返回N
     * 适用业务：如：渠道进件中职业选择学生，
     * 则与该职业相关的字段如班级、年级、寝室等字段可能要求必输，
     * 此时返回Y，结合上面的方法，则可约束相关字段是否必输。
     * </p>
     *
     * @param map
     * @param key   判断的key，需通过此key取出值，与参数value进行比对
     * @param value 要比对的值
     * @return
     */
    @Deprecated
    public static String ifY(Map map, String key, String value) throws Exception {
        logger.debug("parms:【map=" + map + ";key=" + key + ";value=" + value + "】");
        if (map == null || key == null) {
            throw new Exception("参数异常");
        }
        if (map.containsKey(key)) {
            String keyValue = String.valueOf(map.get(key));
            if (Objects.equals(keyValue, value)) {
                return "Y";
            }
            return "N";
        } else {
            return "N";
        }
    }


    /**
     * <p>
     * 将参数map中的value值为null的置为空字符串
     * 适用业务：通用BaseMapper中的updateNotNullByPrimaryKey(Object obj)方法会将对象中不为null的值进行更新，
     * 故当需求要求前端已传的字段，不管值是否为null，均需更新时，
     * 通过此方法将参数中为null的值置为“”，
     * 以便通过updateNotNullByPrimaryKey(Object obj)将数据库中的相应属性值置为空。
     * <p>
     * </p>
     *
     * @param map
     * @return
     */
    public static Map<String, Object> getNeedsUpdateMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (map.get(key) == null) {
                map.put(key, "");
            }
        }
        return map;
    }


    /**
     * 赋值默认值
     *
     * @param map
     * @param defaultVal
     */
    public static void setMapDefault(Map<String, Object> map, Object defaultVal) {

        if ((map != null) && (!map.isEmpty())) {
            Set<String> set = map.keySet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String key = it.next();
                if (map.get(key) == null) {
                    map.put(key, defaultVal);
                }
            }
        }
    }
}


