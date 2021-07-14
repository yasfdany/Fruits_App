package com.rifqiananda.fruitsmart.bottomnavbar.fragments

import android.app.ActionBar
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewConfiguration.get
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifqiananda.fruitsmart.Fruits
import com.rifqiananda.fruitsmart.R
import com.rifqiananda.fruitsmart.adapter.MyAdapter
import com.rifqiananda.fruitsmart.bottomnavbar.FruitsDetail
import com.rifqiananda.fruitsmart.bottomnavbar.ReadActivity
import com.rifqiananda.fruitsmart.listener.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.recycler_view
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.recycler_view_template.*
import kotlinx.android.synthetic.main.recycler_view_template.color_card1
import kotlinx.android.synthetic.main.recycler_view_template.color_card2
import kotlinx.android.synthetic.main.recycler_view_template.view.*
import java.lang.reflect.Array.get

class HomeFragment : Fragment()
{
    // TODO: Rename and change types of parameters

    lateinit var adapterFruits : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply{

            var data = ArrayList<Fruits>()
            data.add(Fruits(R.drawable.apple_cover, txtName = "Apple", txtPrice = "Rp10.000,00", txtDesc = "Ini Deskripsi Apel"))
            data.add(Fruits(R.drawable.dragon_fruit_cover, txtName = "Dragon\nFruit", txtPrice = "Rp12.000,00", txtDesc = "Ini Deskripsi Dragon Fruit"))
            data.add(Fruits(R.drawable.nanas_cover, txtName = "Pineapple", txtPrice = "Rp15.000,00", txtDesc = "Ini Deskripsi Pineapple"))
            data.add(Fruits(R.drawable.orange_cover, txtName = "Orange", txtPrice = "Rp7.000,00", txtDesc = "Ini Deskripsi Orange"))
            data.add(Fruits(R.drawable.banana_cover, txtName = "Banana", txtPrice = "Rp9.000,00", txtDesc = "Ini Deskripsi Banana"))
            data.add(Fruits(R.drawable.star_fruit_cover, txtName = "Star Fruit", txtPrice = "Rp9.500,00", txtDesc = "Ini Deskripsi Star Fruit"))
            data.add(Fruits(R.drawable.avocado_cover, txtName = "Avocado", txtPrice = "Rp13.000,00", txtDesc = "Ini Deskripsi Avocado"))
            data.add(Fruits(R.drawable.watermelons_cover, txtName = "Water-\nmelons", txtPrice = "Rp15.000,00", txtDesc = "Ini Deskripsi Watermelons"))
            data.add(Fruits(R.drawable.blueberry_cover, txtName = "Blueberry", txtPrice = "Rp2.000,00", txtDesc = "Ini Deskripsi Blueberry"))
            data.add(Fruits(R.drawable.grape_cover, txtName = "Grape", txtPrice = "Rp1.000,00", txtDesc = "Ini Deskripsi Grape"))

            adapterFruits = MyAdapter(context, data)
            layoutManager = LinearLayoutManager(activity)
            recycler_view.adapter = adapterFruits

        }

        btn_read.setOnClickListener {
            val intent = Intent (context, ReadActivity::class.java)
            startActivity(intent)
        }
    }



}


