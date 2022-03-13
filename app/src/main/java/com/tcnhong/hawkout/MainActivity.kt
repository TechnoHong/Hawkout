package com.example.hawkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hawkout.databinding.ActivityMainBinding
import com.tcnhong.hawkout.database.ExerciseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainStartBtn.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }

        binding.mainCalculatorBtn.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        val db = ExerciseDatabase.getInstance(applicationContext)!!

        CoroutineScope(Dispatchers.Main).launch {
            val exercises = CoroutineScope(Dispatchers.IO).async {
                db.exerciseDao().getAll()
            }.await()
            Log.d("TAG",exercises.toString())
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}