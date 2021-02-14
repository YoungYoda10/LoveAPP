package com.vladimirvozar.loveapp.models;

import android.util.Log;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vladimirvozar.loveapp.BR;

public class HeartData extends ViewModel {

    private MutableLiveData<Float> verticalHelper1 = new MutableLiveData<>();
    private MutableLiveData<Float> verticalHelper2 = new MutableLiveData<>();

    private MutableLiveData<Float> horizontalHelper1 = new MutableLiveData<>();
    private MutableLiveData<Float> horizontalHelper2 = new MutableLiveData<>();

    private int clickCounter;

    private MutableLiveData<Boolean> textVisible = new MutableLiveData<>();

    public HeartData() {
        verticalHelper1.setValue(0.30f); //30%
        verticalHelper2.setValue(0.70f); //70%

        horizontalHelper1.setValue(0.40f); //40%
        horizontalHelper2.setValue(0.60f); //60%

        clickCounter = 0;
    }

    public void increaseGuideLine() {
        clickCounter++;
        if (clickCounter <= 4) {
            verticalHelper1.setValue(getVerticalHelper1().getValue() - 0.1f);
            verticalHelper2.setValue(getVerticalHelper2().getValue() + 0.1f);

            horizontalHelper1.setValue(getHorizontalHelper1().getValue() - 0.1f);
            horizontalHelper2.setValue(getHorizontalHelper2().getValue() + 0.1f);

            if (clickCounter == 4) {
                textVisible.setValue(true);
            }
        }
    }

    public MutableLiveData<Float> getVerticalHelper1() {
        return verticalHelper1;
    }

    public void setVerticalHelper1(MutableLiveData<Float> verticalHelper1) {
        this.verticalHelper1 = verticalHelper1;
    }

    public MutableLiveData<Float> getVerticalHelper2() {
        return verticalHelper2;
    }

    public void setVerticalHelper2(MutableLiveData<Float> verticalHelper2) {
        this.verticalHelper2 = verticalHelper2;
    }

    public MutableLiveData<Float> getHorizontalHelper1() {
        return horizontalHelper1;
    }

    public void setHorizontalHelper1(MutableLiveData<Float> horizontalHelper1) {
        this.horizontalHelper1 = horizontalHelper1;
    }

    public MutableLiveData<Float> getHorizontalHelper2() {
        return horizontalHelper2;
    }

    public void setHorizontalHelper2(MutableLiveData<Float> horizontalHelper2) {
        this.horizontalHelper2 = horizontalHelper2;
    }

    public MutableLiveData<Boolean> getTextVisible() {
        return textVisible;
    }

    public void setTextVisible(MutableLiveData<Boolean> textVisible) {
        this.textVisible = textVisible;
    }

    @BindingAdapter("layout_constraintGuide_begin")
    public static void setLayoutConstraintGuideBegin(Guideline guideline, float percent) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) guideline.getLayoutParams();
        params.guidePercent = percent;
        guideline.setLayoutParams(params);
    }
}
