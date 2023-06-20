package com.example.e_bookstore.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_bookstore.R
import com.example.e_bookstore.databinding.ActivityHomeBinding
import com.example.e_bookstore.fragments.CategoriesFragment
import com.example.e_bookstore.fragments.FavouriteFragment
import com.example.e_bookstore.fragments.HomeFragment
import com.example.e_bookstore.fragments.ShopFragment


class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icHome -> replaceFragment(HomeFragment())
                R.id.icFav -> replaceFragment(FavouriteFragment())
                R.id.icShop -> replaceFragment(ShopFragment())
                R.id.icCate -> replaceFragment(CategoriesFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}
