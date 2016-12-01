package com.yeelight.sdk.device;

public class ColorFlowItem {
    public int duration;
    public int mode;
    public int value;
    public int brightness;

    @Override
    public String toString() {
        return "ColorFlowItem [duration=" + duration + ", mode=" + mode + ", value=" + value + ", brightness="
                + brightness + "]";
    }

}
