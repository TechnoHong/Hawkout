package com.example.hawkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hawkout.databinding.ActivityWorkoutBinding

class WorkoutActivity: AppCompatActivity() {

    private var mBinding: ActivityWorkoutBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}