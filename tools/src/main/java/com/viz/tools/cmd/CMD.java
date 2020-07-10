package com.viz.tools.cmd;

import java.io.DataOutputStream;

/**
 * Created by viz on 2014/11/14.
 */
public class CMD {
    public void startCMD(String[] cmd) {
        Process process = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec("su");//transfer to root
            os = new DataOutputStream(process.getOutputStream());
            for(String c:cmd){
                os.writeBytes(c+"\n");
            }
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                    process.destroy();
                }
            } catch (Exception e) {

            }
        }
    }
}
