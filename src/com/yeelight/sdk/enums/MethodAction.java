package com.yeelight.sdk.enums;

public enum MethodAction {

    PROP("get_prop"),
    SWITCH("set_power"),
    TOGGLE("toggle"),
    BRIGHTNESS("set_bright"),
    COLORTEMPERATURE("set_ct_abx"),
    HSV("set_hsv"),
    RGB("set_rgb"),
    DEFAULT("set_default"),
    STARTCF("start_cf"),
    STOPCF("setop_cf"),
    SCENE("set_scene"),
    CRON_ADD("cron_add"),
    CRON_GET("cron_get"),
    CRON_DEL("cron_del"),
    ADJUST("set_adjust"),
    MUSIC("set_music"),
    NAME("set_name");

    public String action;

    MethodAction(String action) {
        this.action = action;
    }
}
