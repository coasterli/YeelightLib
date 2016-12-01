package com.yeelight.sdk.device;

import java.util.HashMap;

import com.yeelight.sdk.CommonLogger;
import com.yeelight.sdk.enums.DeviceType;

public class DeviceFactory {
    public static DeviceBase build(String model, String id) {
        DeviceType type = DeviceType.valueOf(model);
        switch (type) {
            case ceiling:
                return new CeilingDevice(id);
            case color:
                return new WonderDevice(id);
            case mono:
                return new MonoDevice(id);
            case stripe:
                return new PitayaDevice(id);
            default:
                return null;
        }
    }

    public static DeviceBase build(HashMap<String, String> bulbInfo) {
        DeviceType type = DeviceType.valueOf(bulbInfo.get("model"));
        DeviceBase device;
        switch (type) {
            case ceiling:
                device = new CeilingDevice(bulbInfo.get("id"));
                break;
            case color:
                device = new WonderDevice(bulbInfo.get("id"));
                break;
            case mono:
                device = new MonoDevice(bulbInfo.get("id"));
                break;
            case stripe:
                device = new PitayaDevice(bulbInfo.get("id"));
                break;
            default:
                return null;
        }
        HashMap<String, Object> infos = new HashMap<>();
        infos.putAll(bulbInfo);
        device.setBulbInfo(infos);
        CommonLogger.debug("DeviceFactory Device = " + bulbInfo.get("Location"));
        // TODO enhancement!!!
        String[] addressInfo = bulbInfo.get("Location").split(":");
        device.setAddress(addressInfo[1].substring(2));
        device.setPort(Integer.parseInt(addressInfo[2]));
        device.setOnline(true);
        CommonLogger.debug("DeviceFactory Device info = " + device.getAddress() + ", port = " + device.getPort());
        return device;
    }

}
