package com.rifqiananda.fruitsmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rifqiananda.fruitsmart.bottomnavbar.fragments.AboutFragment
import com.rifqiananda.fruitsmart.bottomnavbar.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val aboutFragment = AboutFragment()

        makeCurrentFragment(homeFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> makeCurrentFragment(homeFragment)
                R.id.item_user -> makeCurrentFragment(aboutFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_fragment, fragment)
                commit()
    }
}