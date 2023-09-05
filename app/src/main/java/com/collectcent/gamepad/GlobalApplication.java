package com.collectcent.gamepad;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;

public class GlobalApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        String appToken = "sf6eearwjitc";
        String enviroment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(this,appToken,enviroment);
        config.setLogLevel(LogLevel.WARN);
        Adjust.onCreate(config);


        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }
    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks
    {

        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }


    //    @Override
//    public void onCreate()
//    {
//        super.onCreate();
//
//        String appToken="{sf6eearwjitc}";
//        String environment= AdjustConfig.ENVIRONMENT_SANDBOX;
//        AdjustConfig config = new AdjustConfig(this, appToken,environment);
//        Adjust.onCreate(config);
//        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());
//    }
//    private static final class AdjustLifecycleCallbacks implements ActivityLifecycleCallbacks
//    {
//        @Override
//        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
//
//        }
//
//        @Override
//        public void onActivityStarted(@NonNull Activity activity) {
//
//        }
//
//        @Override
//        public void onActivityResumed(@NonNull Activity activity) {
//            Adjust.onResume();
//        }
//
//        @Override
//        public void onActivityPaused(@NonNull Activity activity) {
//            Adjust.onPause();
//        }
//
//        @Override
//        public void onActivityStopped(@NonNull Activity activity) {
//
//        }
//
//        @Override
//        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
//
//        }
//
//        @Override
//        public void onActivityDestroyed(@NonNull Activity activity) {
//
//        }
//    }

}
