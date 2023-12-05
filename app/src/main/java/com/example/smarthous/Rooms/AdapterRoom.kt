package com.example.smarthous.Rooms

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthous.R
import io.ktor.client.engine.callContext
import io.ktor.http.parameters

class AdapterRoom(val room: ArrayList<Room>): RecyclerView.Adapter<AdapterRoom.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val roomImageBut: ImageButton = itemView.findViewById(R.id.roomImage)
        val roomNameText: TextView = itemView.findViewById(R.id.roomName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRoom.MyViewHolder {
        val listView = LayoutInflater.from(parent.context).inflate(R.layout.choose_a_room, parent, false)
        return MyViewHolder(listView)
    }

    override fun getItemCount(): Int {
        return room.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rooms = room.get(position)
        val drawable = getDrawableFromString(rooms.Иконка)
        holder.roomImageBut.setImageDrawable(drawable)
        holder.roomNameText.text = rooms.БазовоеИмя
    }

    private fun getDrawableFromString(room: String): Drawable? {
        val resourceId = room.resources.es.getIdentifier(room, "", room.packageName)

            return
        ContextCompat.getDrawable(room, resourceId)
    }
}