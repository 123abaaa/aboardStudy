
package com.utils;

import org.apache.commons.lang3.StringUtils;

import com.entity.EIException;


public class SQLFilter {

    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        str = str.toLowerCase();

        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new EIException("Contains illegal characters");
            }
        }

        return str;
    }
}
