package com.xxl.job.core.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xuxueli on 17/5/9.
 */
public enum ExecutorBlockStrategyEnum {

    SERIAL_EXECUTION("Serial execution"),
    /*CONCURRENT_EXECUTION("并行"),*/
    DISCARD_LATER("Discard Later"),
    COVER_EARLY("Cover Early");

    private String title;
    private ExecutorBlockStrategyEnum (String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public static ExecutorBlockStrategyEnum match(String name, ExecutorBlockStrategyEnum defaultItem) {
        if (name != null) {
            for (ExecutorBlockStrategyEnum item:ExecutorBlockStrategyEnum.values()) {
                if (item.name().equals(name)) {
                    return item;
                }
            }
        }
        return defaultItem;
    }

    public static List<HashMap<String, Object>> getEnumList() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (ExecutorBlockStrategyEnum e : EnumSet.allOf(ExecutorBlockStrategyEnum.class)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("value", e.name());
            map.put("label", e.title);
            list.add(map);
        }
        return list;
    }
}
