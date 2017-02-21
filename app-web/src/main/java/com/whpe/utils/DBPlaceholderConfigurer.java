package com.whpe.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

public class DBPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected Properties mergeProperties() throws IOException {
//        Properties properties = new Properties();
//        properties.put("jdbc.url", "jdbc:mysql://127.0.0.2:3306/test?characterEncoding=utf8");
//        ConfigUtils.mergeProperties(properties, super.mergeProperties());
        return super.mergeProperties();
    }
}
