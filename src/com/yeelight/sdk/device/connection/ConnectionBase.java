package com.yeelight.sdk.device.connection;

import com.yeelight.sdk.device.DeviceMethod;

/**
 * Created by jiang on 16/10/21.
 */

public interface ConnectionBase {

    boolean invoke(DeviceMethod method);

    boolean connect();

    boolean disconnect();

}
