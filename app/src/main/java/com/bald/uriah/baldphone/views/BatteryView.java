/*
 * Copyright 2019 Uriah Shaul Mandel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bald.uriah.baldphone.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.bald.uriah.baldphone.R;
import com.bald.uriah.baldphone.utils.D;

public class BatteryView extends BaldImageButton {
    public int percentage;

    public BatteryView(Context context) {
        super(context);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLevel(int level, boolean charged) {
        percentage = level;
        @DrawableRes int drawableRes = R.drawable.battery_unknown_on_background;
        if (charged) {
            if (level < 20) {
                drawableRes = R.drawable.battery_20_c_on_background;
            } else if (level < 30) {
                drawableRes = R.drawable.battery_30_c_on_background;
            } else if (level < 50) {
                drawableRes = R.drawable.battery_50_c_on_background;
            } else if (level < 60) {
                drawableRes = R.drawable.battery_60_c_on_background;
            } else if (level < 80) {
                drawableRes = R.drawable.battery_80_c_on_background;
            } else if (level < 90) {
                drawableRes = R.drawable.battery_90_c_on_background;
            } else if (level < 100) {
                drawableRes = R.drawable.battery_100_charging;
            } else
                drawableRes = R.drawable.ic_battery;
        } else {
            if (level < D.LOW_BATTERY_LEVEL) {
                drawableRes = R.drawable.ic_battery_empty;
            } else if (level < 30) {
                drawableRes = R.drawable.ic_battery;
            } else if (level < 50) {
                drawableRes = R.drawable.ic_battery;
            } else if (level < 60) {
                drawableRes = R.drawable.ic_battery_full;
            } else if (level < 80) {
                drawableRes = R.drawable.ic_battery_full;
            } else if (level < 90) {
                drawableRes = R.drawable.ic_battery_full;
            } else if (level <= 100) {
                drawableRes = R.drawable.ic_battery_full;
            }

        }
        setImageResource(drawableRes);
    }
}
