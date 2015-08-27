package com.viz.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private Properties props = new Properties();
    private boolean isNull = false;

    public Config(String propertiesName) {
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream(propertiesName + ".properties");
            if (null != inputStream) {
                props.load(inputStream);
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("文件" + propertiesName + ".properties不存在");
            isNull = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringValue(String key) {
        if (!isNull) {
            return props.getProperty(key);
        } else {
            return null;
        }
    }

    public boolean getBooleanValue(String key) {
        if (!isNull) {
            String value = props.getProperty(key);
            if (value.equals("true")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
