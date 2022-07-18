package com.xxl.job.admin.core.scheduler;

import com.xxl.job.admin.core.util.I18nUtil;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

/**
 * @author xuxueli 2020-10-29 21:11:23
 */
public enum ScheduleTypeEnum {

    NONE(I18nUtil.getString("schedule_type_none")),

    /**
     * schedule by cron
     */
    CRON(I18nUtil.getString("schedule_type_cron")),

    /**
     * schedule by fixed rate (in seconds)
     */
    FIX_RATE(I18nUtil.getString("schedule_type_fix_rate")),

    /**
     * schedule by fix delay (in seconds)， after the last time
     */
    /*FIX_DELAY(I18nUtil.getString("schedule_type_fix_delay"))*/;

    private String title;

    ScheduleTypeEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ScheduleTypeEnum match(String name, ScheduleTypeEnum defaultItem){
        for (ScheduleTypeEnum item: ScheduleTypeEnum.values()) {
            if (item.name().equals(name)) {
                return item;
            }
        }
        return defaultItem;
    }

    public static List<HashMap<String, Object>> getEnumList() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (ScheduleTypeEnum e : EnumSet.allOf(ScheduleTypeEnum.class)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("value", e.name());
            map.put("label", e.title);
            list.add(map);
        }
        return list;
    }
}
