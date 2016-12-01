package com.yeelight.sdk.device;

import java.util.List;

import com.yeelight.sdk.enums.DeviceMode;

public class DeviceStatus {

    public static final int MODE_COLOR = 1;
    public static final int MODE_COLORTEMPERATURE = 2;
    public static final int MODE_HSV = 3;

    public static final int DEFAULT_NO_DELAY = -1;

    private boolean isPowerOff;
    private int r;
    private int g;
    private int b;
    private int color;
    private int brightness;
    private int ct;
    private int hue;
    private int sat;
    private boolean isFlowing;
    private int delayOff = DEFAULT_NO_DELAY;
    private List<ColorFlowItem> mFlowItems;
    private DeviceMode mode;
    private boolean isMusicOn;
    private String name;
    private int flowEndAction;
    private int flowCount;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getCt() {
        return ct;
    }

    public void setCt(int ct) {
        this.ct = ct;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public DeviceMode getMode() {
        return mode;
    }

    public void setMode(DeviceMode mode) {
        this.mode = mode;
    }

    public boolean isPowerOff() {
        return isPowerOff;
    }

    public void setPowerOff(boolean isPowerOff) {
        this.isPowerOff = isPowerOff;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean getIsFlowing() {
        return isFlowing;
    }

    public void setIsFlowing(boolean isFlowing) {
        this.isFlowing = isFlowing;
    }

    public List<ColorFlowItem> getFlowItems() {
        return mFlowItems;
    }

    public void setFlowItems(List<ColorFlowItem> mFlowItems) {
        this.mFlowItems = mFlowItems;
    }

    public boolean isMusicOn() {
        return isMusicOn;
    }

    public void setMusicOn(boolean isMusicOn) {
        this.isMusicOn = isMusicOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelayOff() {
        return delayOff;
    }

    public void setDelayOff(int delayOff) {
        this.delayOff = delayOff;
    }

    @Override
    public String toString() {
        return "DeviceStatus [isPowerOff=" + isPowerOff + ", r=" + r + ", g=" + g + ", b=" + b + ", color=" + color
                + ", brightness=" + brightness + ", ct=" + ct + ", hue=" + hue + ", sat=" + sat + ", isFlowing="
                + isFlowing + ", delayOff=" + delayOff + ", mFlowItems=" + mFlowItems + ", mode=" + mode
                + ", isMusicOn=" + isMusicOn + ", name=" + name + "]";
    }

    public int getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(int flowCount) {
        this.flowCount = flowCount;
    }

    public int getFlowEndAction() {
        return flowEndAction;
    }

    public void setFlowEndAction(int flowEndAction) {
        this.flowEndAction = flowEndAction;
    }

}
