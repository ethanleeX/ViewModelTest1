package me.masteryi.myjetpackdemo.viewmodeltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import me.masteryi.myjetpackdemo.R
import me.masteryi.myjetpackdemo.databinding.ViewModelTestActivityBinding

class ViewModelTestActivity : AppCompatActivity() {
    lateinit var binding: ViewModelTestActivityBinding
    lateinit var viewModel: ViewModelTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelTestViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.view_model_test_activity)

        binding.lifecycleOwner = this
        binding.data = viewModel

        binding.viewPager.adapter = MyAdapter(this)

        binding.plus.setOnClickListener {
            viewModel.updateData(1)
        }

        binding.minus.setOnClickListener {
            viewModel.updateData(-1)
        }
    }
}