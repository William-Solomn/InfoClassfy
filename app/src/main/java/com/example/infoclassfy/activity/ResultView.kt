package com.example.infoclassfy.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import com.example.infoclassfy.R
import com.example.infoclassfy.activity.InputTextActivity.inputTextData
import com.example.infoclassfy.data.InputTextData
import kotlinx.android.synthetic.main.activity_result_view.*

class ResultView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_view)

        textTitle.setText(inputTextData.TextTitle)
        textContent.setText(inputTextData.TextContent)
        textAnimationStart()

    }

    fun textAnimationStart(){
        val translateAnimationForTitle = TranslateAnimation(0F, 0F,0F,-150F);
        val translateAnimationForContent = TranslateAnimation(0F, 0F,0F,-450F);

        translateAnimationForTitle.fillAfter = true         //it can keep it after the animation
        translateAnimationForContent.fillAfter = true         //it can keep it after the animation
        translateAnimationForTitle.duration = 1000    // the animation will keep 1500 ms
        translateAnimationForContent.duration = 1000    // the animation will keep 1500 ms
        textTitle.animation = translateAnimationForTitle
        textContent.animation = translateAnimationForContent

    }

}