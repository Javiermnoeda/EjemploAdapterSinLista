package com.cbellmont.ejemploadaptersinlista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class StringAdapter : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    class StringViewHolder(var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    var numeroDeFilas = 10

    // Aquí solo obtenemos las vistas que están dentro de layout en el que queremos mostrar nuestros elementos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    // Aquí devolvemos el número de elementos que habrá en nuestro recylcerView
    override fun getItemCount(): Int {
        return numeroDeFilas +  1
    }


    // Aquí ponermos en el layout vacío que hemos creado en el onCreateViewHolder los datos del elemento
    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.textView.text = position.toString()

        if (position < numeroDeFilas){
            holder.textView.text=if(position%2!=0){
                "Soy Impar"
            } else {
                holder.textView.setBackgroundColor(ContextCompat.getColor(holder.root.context, R.color.colorPrimary))
                "Posicion = $position"
            }
        } else {
            if (position == numeroDeFilas){
                holder.textView.text="Soy el último"
            }
        }
    }
}

