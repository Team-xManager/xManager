package com.xc3fff0e.xmanager;

import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;
import android.content.res.*;
import android.graphics.*;
import android.view.Gravity;

public class xC3FFF0E{

public static void setBackgroundGradient(View view, int color1, int color2){
GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] {color1,color2});
view.setBackgroundDrawable(gd);
}

public static void setRoundedRipple(View v,int LT,int RT,int RB,int LB,int color1,int size,int color2,int color3){
GradientDrawable shape = new GradientDrawable();
shape.setColor(color1);
shape.setCornerRadii(new float[]{(float)LT,(float)LT,(float)RT,(float)RT,(float)RB,(float)RB,(float)LB,(float)LB});
shape.setStroke(size, color2);
RippleDrawable ripdr = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{color3}), shape, null);
v.setBackgroundDrawable(ripdr);
}
}