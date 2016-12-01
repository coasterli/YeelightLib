package com.yeelight.sdk.listeners;

import com.yeelight.sdk.device.DeviceBase;

public interface DeviceListener {
    void onDeviceFound(DeviceBase device);

    void onDeviceLost(DeviceBase device);
}
