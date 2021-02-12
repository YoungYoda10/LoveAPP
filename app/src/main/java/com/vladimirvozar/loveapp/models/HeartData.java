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
    private Observer observer = new Observer();

    public Observer getObserver() {
        return observer;
    }

    public static class Observer extends BaseObservable {
        private MutableLiveData<Float> verticalHelper1 = new MutableLiveData<>();
        private MutableLiveData<Float> verticalHelper2 = new MutableLiveData<>();

        private MutableLiveData<Float> horizontalHelper1 = new MutableLiveData<>();
        private MutableLiveData<Float> horizontalHelper2 = new MutableLiveData<>();

        private int clickCounter;

        private MutableLiveData<Boolean> textVisible = new MutableLiveData<>();

        public Observer() {
            verticalHelper1.setValue(0.30f); //30%
            verticalHelper2.setValue(0.70f); //70%

            horizontalHelper1.setValue(0.40f); //40%
            horizontalHelper2.setValue(0.60f); //60%

            textVisible.setValue(false);

            clickCounter = 1;
        }

        public void increaseGuideLine() {
            if (clickCounter < 5) {
                verticalHelper1.setValue(getVerticalHelper1() - 0.1f);
                verticalHelper2.setValue(getVerticalHelper2() + 0.1f);

                horizontalHelper1.setValue(getHorizontalHelper1() - 0.1f);
                horizontalHelper2.setValue(getHorizontalHelper2() + 0.1f);

                clickCounter++;

                if(clickCounter == 5){
                    textVisible.setValue(true);
                    notifyPropertyChanged(BR.textVisible);
                }

                notifyPropertyChanged(BR._all);
            } else {
                textVisible.setValue(true);
                notifyPropertyChanged(BR.textVisible);
            }
        }

        @Bindable
        public float getVerticalHelper1() {
            return verticalHelper1.getValue();
        }

        @Bindable
        public float getVerticalHelper2() {
            return verticalHelper2.getValue();
        }

        @Bindable
        public float getHorizontalHelper1() {
            return horizontalHelper1.getValue();
        }

        @Bindable
        public float getHorizontalHelper2() {
            return horizontalHelper2.getValue();
        }

        @Bindable
        public boolean getTextVisible() {
            return textVisible.getValue();
        }

        @Bindable
        public void setTextVisible(boolean textVisible) {
            this.textVisible.setValue(textVisible);
        }
    }

    @BindingAdapter("layout_constraintGuide_begin")
    public static void setLayoutConstraintGuideBegin(Guideline guideline, float percent) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) guideline.getLayoutParams();
        params.guidePercent = percent;
        guideline.setLayoutParams(params);
    }
}
