package com.viz.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by viz on 2014/10/28.
 */
public class ServiceHelper {
    private Context context;
    private String classname;

    public ServiceHelper(Context context) {
        this.context = context;
    }

    // -------------------------------------------
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(classname + " Connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(classname + "  DisConnected!");
        }
    };

    /**
     * 绑定服务
     *
     * @param service 服务类名
     */
    public void bindService(Class service) {
        classname = service.getName();
        Intent bindLogIntent = new Intent(context, service);
        context.bindService(bindLogIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     *
     * 解绑服务
     *
     */
    public void unbindService(){
        context.unbindService(serviceConnection);
    }
}
