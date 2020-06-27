package com.example.rodoggx.codechallenge.utils;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CardViewType {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TYPE_TEXT, TYPE_TITLE, TYPE_IMAGE})
    public @interface ItemTypeDef {}

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_TITLE = 1;
    public static final int TYPE_IMAGE = 2;
}
