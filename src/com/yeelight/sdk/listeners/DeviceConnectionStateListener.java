package com.yeelight.sdk.listeners;

import com.yeelight.sdk.device.ConnectState;

public interface DeviceConnectionStateListener {
    void onConnectionStateChanged(ConnectState connectState);
}
