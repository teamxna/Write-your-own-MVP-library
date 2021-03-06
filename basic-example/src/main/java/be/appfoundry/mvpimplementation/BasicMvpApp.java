package be.appfoundry.mvpimplementation;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class BasicMvpApp extends Application {

    @Nullable
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // LeakCanary Impl

    public static void watch(final Context context) {
        final BasicMvpApp application = (BasicMvpApp) context.getApplicationContext();
        if (application.refWatcher != null) {
            application.refWatcher.watch(context);
        }
    }
}
