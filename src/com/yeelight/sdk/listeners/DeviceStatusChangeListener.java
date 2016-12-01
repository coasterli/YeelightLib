package com.yeelight.sdk.listeners;

import com.yeelight.sdk.device.DeviceStatus;

public interface DeviceStatusChangeListener {
    void onStatusChanged(String prop, DeviceStatus status);
}
