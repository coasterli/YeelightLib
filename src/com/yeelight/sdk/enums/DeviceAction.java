package com.yeelight.sdk.enums;

public enum DeviceAction {
    open,
    close,
    brightness,
    color,
    colortemperature

    ;

    private String mStrValue;
    private int mIntValue;

    public void putValue(String value) {
        this.mStrValue = value;
    }

    public void putValue(int value) {
        this.mIntValue = value;
    }

    public String strValue() {
        return mStrValue;
    }

    public int intValue() {
        return mIntValue;
    }
}
