package com.example.hawkout

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hawkout.databinding.ActivityCalculatorBinding

class CalculatorActivity: AppCompatActivity() {
    private var mBinding: ActivityCalculatorBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dropDownItem = listOf(
            resources.getString(R.string.rm_type_1),
            resources.getString(R.string.rm_type_2))

        binding.calEstimationDropdownField.setText(HawkoutApplication.prefs.getString("1rm_type", resources.getString(R.string.rm_type_1)))
        val adapter = ArrayAdapter(this, R.layout.cal_list_item, dropDownItem)
        binding.calEstimationDropdownField.setAdapter(adapter)

        binding.calEstimationDropdownField.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                HawkoutApplication.prefs.setString("1rm_type", dropDownItem[i])
            }

        binding.calRepTextField.setOnKeyListener { view, i, keyEvent ->
            if ((keyEvent.action == KeyEvent.ACTION_DOWN) && i == KeyEvent.KEYCODE_ENTER) {
                binding.calCalbtn.performClick()
                true
            }
            false
        }

        binding.calCalbtn.setOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            it.clearFocus()

            val repMax100 = calRepMax(binding.calWeightTextField.text.toString().toFloat(), (binding.calRepTextField.text.toString().toFloat()))

            binding.calRepmax.text = repMax100.toString()

            binding.cal95.text = (repMax100 / 0.95).toInt().toString()
            binding.cal90.text = (repMax100 / 0.90).toInt().toString()
        }
    }

    private fun calRepMax(weight: Float, rep: Float): Int {
        return when(HawkoutApplication.prefs.getString("1rm_type", resources.getString(R.string.rm_type_1))) {
            resources.getString(R.string.rm_type_1) -> (weight*(36/(37-rep))).toInt()
            resources.getString(R.string.rm_type_2) -> (weight*(1+rep/30)).toInt()
            else -> 999
        }
    }
}