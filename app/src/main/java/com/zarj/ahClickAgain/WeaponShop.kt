package com.zarj.ahClickAgain

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.zarj.ahClickAgain.databinding.ActivityWeaponShopBinding

class WeaponShop : AppCompatActivity() {

    private lateinit var binding: ActivityWeaponShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityWeaponShopBinding.inflate(layoutInflater)


        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}