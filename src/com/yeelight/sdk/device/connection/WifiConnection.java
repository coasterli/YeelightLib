package com.yeelight.sdk.device.connection;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

import com.yeelight.sdk.CommonLogger;
import com.yeelight.sdk.device.ConnectState;
import com.yeelight.sdk.device.DeviceBase;
import com.yeelight.sdk.device.DeviceMethod;
import com.yeelight.sdk.services.DeviceManager;

/**
 * Created by jiang on 16/10/25.
 */

public class WifiConnection implements ConnectionBase {

    private Socket mSocket;
    private BufferedReader mReader;
    private BufferedOutputStream mWriter;
    private Thread mConnectThread;
    private DeviceBase mDevice;
    private boolean mCmdRun = false;

    Logger mLogger = Logger.getLogger(DeviceManager.class.getSimpleName());

    public WifiConnection(DeviceBase device) {
        mDevice = device;
    }

    @Override
    public boolean invoke(DeviceMethod method) {
        if (mWriter != null) {
            try {
                mWriter.write(method.getParamsStr().getBytes());
                mWriter.flush();
                mLogger.info("########Write Success!");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                mLogger.info("######## write exception, set device to disconnected!");
                e.printStackTrace();
                mDevice.setConnectionState(ConnectState.DISCONNECTED);
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean connect() {
        mLogger.info("######## connect() entering!");
        if (mSocket != null && mSocket.isConnected()) {
            mLogger.info("######## socket not null, return!");
            return true;
        }
        mConnectThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mCmdRun = true;
                    mLogger.info("######## connect device!" + mDevice.getAddress() + ", " + mDevice.getPort());
                    mSocket = new Socket(mDevice.getAddress(), mDevice.getPort());
                    mSocket.setKeepAlive(true);
                    mWriter = new BufferedOutputStream(mSocket.getOutputStream());
                    mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                    mDevice.setConnectionState(ConnectState.CONNECTED);
                    while (mCmdRun) {
                        try {
                            String value = mReader.readLine();
                            mLogger.info("######## get response:" + value);
                            if (value == null) {
                                mCmdRun = false;
                            } else {
                                mDevice.onNotify(value);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            mCmdRun = false;
                        }
                    }
                    mSocket.close();
                } catch (Exception e) {
                    CommonLogger.debug("######## connect device! ERROR!" + e.getMessage());
                    e.printStackTrace();
                } finally {
                    mDevice.setConnectionState(ConnectState.DISCONNECTED);
                    mSocket = null;
                }
            }
        });
        mConnectThread.start();
        return false;
    }

    @Override
    public boolean disconnect() {
        mDevice.setAutoConnect(false);
        return false;
    }

}
