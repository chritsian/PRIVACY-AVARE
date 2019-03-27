package app.avare.plugin.apiLogPlugin;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.util.Log;

import java.util.concurrent.Executor;

import app.avare.plugin.apiLogFileWriter.LogWriter;

import static app.avare.yahfa.HookInfo.TAG;

/**
 * Class to write a log entry if camera2 API opens a camera.
 */
public class Hook_camera2_1 {
    public static String className = "android.hardware.camera2.CameraManager";
    public static String methodName = "openCamera";
    public static String methodSig = "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V";

    private static LogWriter logWriter;

    public static void hook(CameraManager thiz, String s, Executor executor, CameraDevice.StateCallback stateCallback) {
        Log.d(TAG, "camera2 hooked");
        logWriter = new LogWriter();
        logWriter.addLine("camera2 called");
        backup(thiz, s, executor, stateCallback);
    }

    public static void backup(CameraManager thiz, String s, Executor executor, CameraDevice.StateCallback stateCallback) {

    }
}
