package com.reactnativesnapyr;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.module.annotations.ReactModule;

import com.snapyr.sdk.Properties;
import com.snapyr.sdk.Snapyr;
import com.snapyr.sdk.Traits;

@ReactModule(name = SnapyrModule.NAME)
public class SnapyrModule extends ReactContextBaseJavaModule {
    public static final String NAME = "Snapyr";

    public SnapyrModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void identify(final String identifyValue, final ReadableMap traits) {
        Traits traitsValues = null;

        if (traits != null) {
            ReadableMapKeySetIterator iterator = traits.keySetIterator();
            traitsValues = new Traits();

            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();
                String value = traits.getString(key);
                traitsValues.putValue(key, value);
            }
        }

        if (identifyValue != null && !identifyValue.isEmpty()) {
            Snapyr.with(getReactApplicationContext()).identify(identifyValue, traitsValues, null);
        }
    }

    @ReactMethod
    public void track(final String eventName, final ReadableMap properties) {
        Properties propertiesValues = null;

        if (properties != null) {
            ReadableMapKeySetIterator iterator = properties.keySetIterator();
            propertiesValues = new Properties();

            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();
                String value = properties.getString(key);
                propertiesValues.putValue(key, value);
            }
        }

        if (eventName != null && !eventName.isEmpty()) {
            Snapyr.with(getReactApplicationContext()).track(eventName, propertiesValues);
        }
    }

    @ReactMethod
    public void reset() {
        Snapyr.with(getReactApplicationContext()).reset();
    }
}
