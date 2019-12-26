package ir.sample.kotlinroom.utils

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import ir.sample.kotlinroom.MainActivity
import ir.sample.kotlinroom.R
import ir.sample.kotlinroom.roomLayer.entities.UserEntity
import kotlinx.android.synthetic.main.model_layout.view.*

class MainAdapter(val context: Activity, val usersList: List<UserEntity>) :
    RecyclerView.Adapter<MainAdapter.MainAdapterHolder>() {

    class MainAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterHolder {
        //Make contact RecyclerView with model_layout by Return View
        val view: View = LayoutInflater.from(context).inflate(R.layout.model_layout, parent, false)
        return MainAdapterHolder(view)
    }

    override fun getItemCount(): Int {
        //Detect Users Quantity
        return usersList.size
    }

    override fun onBindViewHolder(holder: MainAdapterHolder, position: Int) {

        //Get View From ViewHolder
        val view: View=holder.itemView

        //Get Position for ViewAllData From Database
        val user=usersList[position]

        //Initialize & Cast ModelItems
        val cardMain = view.card_model_main
        val txtTitle=view.txt_model_title
        val imgMain=view.img_model_main

        //Set Value  ModelItems
        cardMain.setBackgroundResource(R.drawable.background_model)
        txtTitle.text=user.name
        imgMain.setImageResource(R.drawable.ic_edit_user)

        //Set Listeners
        imgMain.setOnClickListener(View.OnClickListener {
            val editDataIntent=Intent(context , MainActivity::class.java)
            editDataIntent.putExtra("id" , user.id)
            context.startActivity(editDataIntent)

        })
    }
}
















