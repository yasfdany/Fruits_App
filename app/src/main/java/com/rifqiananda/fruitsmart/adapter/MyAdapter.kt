package com.rifqiananda.fruitsmart.adapter

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rifqiananda.fruitsmart.Fruits
import com.rifqiananda.fruitsmart.R
import com.rifqiananda.fruitsmart.bottomnavbar.FruitsDetail
import com.rifqiananda.fruitsmart.listener.OnItemClickListener
import kotlinx.android.synthetic.main.recycler_view_template.view.*


class MyAdapter(private val context: Context, private val data: ArrayList<Fruits>): RecyclerView.Adapter<MyAdapter.FruitsViewHolder>()
{


    private var fruits : MutableList<Fruits> = mutableListOf()
    private var onSelectedListener : OnItemClickListener? = null

    private var imgView : ImageView? = null
    private var txtName : TextView? = null
    private var txtPrice : TextView? = null

    override fun getItemCount(): Int {
        return data.size
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: MyAdapter.FruitsViewHolder, position: Int) {
        holder.bind(data[position])

        if (position == 0)
        {

            holder.itemView.color_card1.setBackgroundColor(ContextCompat.getColor(context, R.color.red_apple))
            holder.itemView.color_card2.setBackgroundColor(ContextCompat.getColor(context, R.color.red_apple))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.FruitsViewHolder {
        return FruitsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_view_template,
                parent,
                false
            )
        )
    }

    fun setFruits(dataF: List<Fruits>)
    {
        fruits.clear()
        fruits.addAll(dataF)
        notifyDataSetChanged()
    }


    fun getData(): MutableList<Fruits>{
        return fruits
    }

    inner class FruitsViewHolder(item: View): RecyclerView.ViewHolder(item){

        private val btnDetail : ImageView = item.findViewById(R.id.btn_detail)

        fun bind(data: Fruits)
        {
            imgView = itemView.findViewById(R.id.image_view)
            txtName = itemView.findViewById(R.id.txt_name)
            txtPrice = itemView.findViewById(R.id.txt_price)


            imgView?.setImageResource(data.imgView)
            txtName?.text = data.txtName
            txtPrice?.text = data.txtPrice

            btnDetail.setOnClickListener {
                val model = data
                var gName : String = model.txtName
                var gPrice : String = model.txtPrice
                var getDesc : String = model.txtDesc
                var gImageView : Int = model.imgView

                val intent = Intent(context, FruitsDetail::class.java)
                intent.putExtra("iImageView", gImageView)
                intent.putExtra("iName", gName)
                intent.putExtra("iPrice", gPrice)
                intent.putExtra("iDesc", getDesc)
                context.startActivity(intent)
            }

            val coba : RelativeLayout

            coba = itemView.findViewById(R.id.color_card1)
            

        }

        init {
            btnDetail.setOnClickListener { onSelectedListener?.onItemClick(it, 0) }
        }
    }


   fun setOnItemClickListener(onClickItemListener: OnItemClickListener){
       this.onSelectedListener = onClickItemListener
   }

}