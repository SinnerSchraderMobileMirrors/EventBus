package org.greenrobot.eventbus.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;


public class EventBusLifecycleObserver implements LifecycleObserver {

    private final LifecycleOwner lifecycleOwner;
    @Nullable private final EventBus eventBus;

    public EventBusLifecycleObserver(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, null);
    }

    public EventBusLifecycleObserver(LifecycleOwner lifecycleOwner, @Nullable EventBus eventBus) {
        this.lifecycleOwner = lifecycleOwner;
        this.eventBus = eventBus;
    }

    @OnLifecycleEvent(Event.ON_START)
    void start() {
        if (eventBus == null) {
            EventBus.getDefault().register(lifecycleOwner);
        } else {
            eventBus.register(lifecycleOwner);
        }
    }

    @OnLifecycleEvent(Event.ON_STOP)
    void stop() {
        if (eventBus == null) {
            EventBus.getDefault().unregister(lifecycleOwner);
        } else {
            eventBus.unregister(lifecycleOwner);
        }
    }

}
