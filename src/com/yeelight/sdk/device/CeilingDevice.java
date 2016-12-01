package com.yeelight.sdk.device;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yeelight.sdk.device.connection.WifiConnection;
import com.yeelight.sdk.enums.DeviceType;

public class CeilingDevice extends DeviceBase {

    public CeilingDevice(String id) {
        super(id);
        mDeviceType = DeviceType.ceiling;
        mConnection = new WifiConnection(this);
    }

    @Override
    public void onNotify(String msg) {
        JsonObject result = new JsonParser().parse(msg).getAsJsonObject();
        try {
            String id = "-1";
            if (result.has("id")) {
                id = result.get("id").getAsString();
                // for cmd transaction.

                if (mQueryList.contains(id)) {
                    mQueryList.remove(id);
                    // DeviceMethod(MethodAction.PROP, new Object[] { "power", "name", "bright", "ct" });
                    JsonArray status = result.get("result").getAsJsonArray();

                    // power:
                    if (status.get(0).toString().equals("\"off\"")) {
                        mDeviceStatus.setPowerOff(true);
                    } else if (status.get(0).toString().equals("\"on\"")) {
                        mDeviceStatus.setPowerOff(false);
                    }

                    // name:
                    mDeviceStatus.setName(status.get(1).getAsString());

                    // brightness:
                    mDeviceStatus.setBrightness(status.get(2).getAsInt());

                    // ct:
                    mDeviceStatus.setCt(status.get(3).getAsInt());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onNotify(msg);
    }
}
