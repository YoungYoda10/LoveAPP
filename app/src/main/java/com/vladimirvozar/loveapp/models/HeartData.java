package com.vladimirvozar.loveapp.models;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

public class HeartData extends ViewModel {

    private ObservableField<Float> verticalHelper1 = new ObservableField<>();
    private ObservableField<Float> verticalHelper2 = new ObservableField<>();

    private ObservableField<Float> horizontalHelper1 = new ObservableField<>();
    private ObservableField<Float> horizontalHelper2 = new ObservableField<>();

    public HeartData() {
        verticalHelper1.set(0.30f); //30%
        verticalHelper2.set(0.70f); //70%

        horizontalHelper1.set(0.40f); //40%
        horizontalHelper2.set(0.60f); //60%
    }

    public float getVerticalHelper1() {
        return verticalHelper1.get();
    }

    public float getVerticalHelper2() {
        return verticalHelper2.get();
    }

    public float getHorizontalHelper1() {
        return horizontalHelper1.get();
    }

    public float getHorizontalHelper2() {
        return horizontalHelper2.get();
    }

    @BindingAdapter("layout_constraintGuide_begin")
    public static void setLayoutConstraintGuideBegin(Guideline guideline, float percent) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) guideline.getLayoutParams();
        params.guidePercent = percent;
        guideline.setLayoutParams(params);
    }
}
