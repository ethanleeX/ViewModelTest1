package me.masteryi.myjetpackdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.masteryi.myjetpackdemo.databinding.ActivityMainBinding
import me.masteryi.myjetpackdemo.viewmodeltest.ViewModelTestActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnJetpackDemo.setOnClickListener {
            val intent = Intent(this, ViewModelTestActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}