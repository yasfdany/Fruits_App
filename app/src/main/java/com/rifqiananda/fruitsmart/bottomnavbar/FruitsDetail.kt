package com.rifqiananda.fruitsmart.bottomnavbar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import androidx.appcompat.app.ActionBar
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.rifqiananda.fruitsmart.MainActivity
import com.rifqiananda.fruitsmart.R
import kotlinx.android.synthetic.main.activity_fruits_detail.*


class FruitsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits_detail)

        val actionBar : ActionBar? = supportActionBar

        var intent = intent
        val aImage = intent.getIntExtra("iImageView", 0)
        val aName = intent.getStringExtra("iName")
        val aPrice = intent.getStringExtra("iPrice")
        val aDesc = intent.getStringExtra("iDesc")

        actionBar?.setTitle(aName)
        tv_name_detail.text = aName
        tv_price_detail.text = aPrice
        tv_desc_detail.text = aDesc
        iv_detail.setImageResource(aImage)

        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}