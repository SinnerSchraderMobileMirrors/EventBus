package org.greenrobot.eventbus.lifecycle;

import android.arch.lifecycle.LifecycleOwner;

import org.greenrobot.eventbus.EventBus;


public class LifecycleEventBus extends EventBus {

    /**
     * Adds an observer to the given {@link LifecycleOwner}s lifecycle to register EventBus when
     * started and unregister when stopped.
     */
    public static void observe(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(new EventBusLifecycleObserver(lifecycleOwner, EventBus.getDefault()));
    }

}
