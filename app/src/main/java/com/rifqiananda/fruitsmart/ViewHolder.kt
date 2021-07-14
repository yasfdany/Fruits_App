package com.rifqiananda.fruitsmart

import android.content.Context
import android.content.Intent
import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rifqiananda.fruitsmart.Fruits
import com.rifqiananda.fruitsmart.R
import com.rifqiananda.fruitsmart.bottomnavbar.FruitsDetail
import kotlinx.android.synthetic.main.recycler_view_template.view.*

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view_template, parent, false))
{
        private var imgView : ImageView? = null
        private var txtName : TextView? = null
        private var txtPrice : TextView? = null

        init
        {
            imgView = itemView.findViewById(R.id.image_view)
            txtName = itemView.findViewById(R.id.txt_name)
            txtPrice = itemView.findViewById(R.id.txt_price)

        }

    fun bind(data: Fruits)
    {
        imgView?.setImageResource(data.imgView)
        txtName?.text = data.txtName
        txtPrice?.text = data.txtPrice
    }

 }
