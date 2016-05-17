package com.dyx.base.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

/**
 * Created by Anthony on 2016/3/3.
 * Class Note:
 * json helper for parsing json
 */
public class JSONObjectHelper {
    /**
     * use reflection , type allowed of json
     */
    private static final Class[] ALLOWED_VALUE_TYPE = { Boolean.class, Double.class,
            Integer.class, Long.class };
    JSONObject jsonObject;
    public JSONObjectHelper(String json) throws JSONException {
        this(new JSONObject(json));
    }
    public JSONObjectHelper(JSONObject jsonObject) {
        if(jsonObject == null){
            throw new NullPointerException();
        }
        this.jsonObject = jsonObject;
    }

    /**
     *get value
     */
    public Object get(String name, Object defaultValue) {
        if (jsonObject.has(name)) {
            try {
                return jsonObject.get(name);
            } catch (JSONException e) {
                // do nothing
            }
        }
        return defaultValue;
    }

    private Object get(Class clazz, String name, Object defaultValue) {
        boolean typeAllowed = false;
        for (Class allowedValueType : ALLOWED_VALUE_TYPE) {
            if (allowedValueType == clazz) {
                typeAllowed = true;
                break;
            }
        }

        if (typeAllowed) {
            Object value = get(name, defaultValue);
            if (value instanceof String) {
                try {
                    Method valueOf = clazz.getMethod("valueOf",
                            new Class[] { String.class });
                    return valueOf.invoke(clazz, (String) value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (clazz.isInstance(value)) {
                return value;
            }
        }

        return defaultValue;
    }

    /**
     * 从Name String数组获取相应的�??
     */

    //String 类型
    public String getString(String[] names, String defaultValue) {
        for(String n: names){
            if(jsonObject.has(n)){
                return getString(n, defaultValue);
            }
        }
        return defaultValue;
    }

    public String getString(String name, String defaultValue) {
        Object value = get(name, defaultValue);
        return value == null ? null : String.valueOf(value);
    }

    //boolean 类型
    public boolean getBoolean(String[] names, boolean defaultValue) {
        for(String n: names){
            if(jsonObject.has(n)){
                return getBoolean(n, defaultValue);
            }
        }
        return defaultValue;
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        return (Boolean) get(Boolean.class, name, defaultValue);
    }

    //double 类型
    public double getDouble(String[] names, double defaultValue) {
        for(String n: names){
            if(jsonObject.has(n)){
                return getDouble(n, defaultValue);
            }
        }
        return defaultValue;
    }

    public double getDouble(String name, double defaultValue) {
        Object value = get(name, defaultValue);
        if (value instanceof String && value.equals("")) {
            return defaultValue;
        }
        return (Double) get(Double.class, name, defaultValue);
    }

    //int 类型
    public int getInt(String[] names, int defaultValue) {
        for(String n: names){
            if(jsonObject.has(n)){
                return getInt(n, defaultValue);
            }
        }
        return defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        return (Integer) get(Integer.class, name, defaultValue);
    }

    //long 类型
    public long getLong(String[] names, long defaultValue) {
        for(String n: names){
            if(jsonObject.has(n)){
                return getLong(n, defaultValue);
            }
        }
        return defaultValue;
    }

    public long getLong(String name, long defaultValue) {
        return (Long) get(Long.class, name, defaultValue);
    }

    //JSONArray 类型
    public JSONArray getJSONArray(String[] names, JSONArray defaultValue){
        for(String n: names){
            if(jsonObject.has(n)){
                try {
                    return jsonObject.getJSONArray(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return defaultValue;
    }

    public JSONArray getJSONArray(String name, JSONArray defaultValue){
        try {
            return jsonObject.getJSONArray(name);
        } catch (JSONException e) {
            return defaultValue;
        }
    }

    //JSONObject 类型
    public JSONObject getJSONObject(String[] names, JSONObject defaultValue){
        for(String n: names){
            if(jsonObject.has(n)){
                try {
                    return jsonObject.getJSONObject(n);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return defaultValue;
    }

    public JSONObject getJSONObject(String name, JSONObject defaultValue){
        try{
            return jsonObject.getJSONObject(name);
        } catch (JSONException e){
            return defaultValue;
        }
    }
}
