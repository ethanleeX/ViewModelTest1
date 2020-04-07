package me.masteryi.myjetpackdemo.viewmodeltest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.masteryi.myjetpackdemo.R
import me.masteryi.myjetpackdemo.databinding.ViewModelTestFragmentBinding

class ViewModelTestFragment : Fragment() {

    companion object {
        fun newInstance() =
            ViewModelTestFragment()
    }

    private lateinit var viewModel: ViewModelTestViewModel
    private lateinit var binding: ViewModelTestFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.view_model_test_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // 这里使用 activity
        viewModel = ViewModelProvider(this).get(ViewModelTestViewModel::class.java)
        binding.data = viewModel
        binding.lifecycleOwner = activity

        binding.plus.setOnClickListener {
            viewModel.updateData(1)
        }

        binding.minus.setOnClickListener {
            viewModel.updateData(-1)
        }
    }
}