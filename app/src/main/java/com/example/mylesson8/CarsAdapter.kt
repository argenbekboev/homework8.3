package com.example.mylesson8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylesson8.databinding.ItemCarsBinding

class CarsAdapter(
    val carsList: ArrayList<Car>,
    val onClick: (position: Int) -> Unit
): RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        return CarsViewHolder(
            ItemCarsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = carsList.size


    inner class CarsViewHolder(private val binding: ItemCarsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val car = carsList[adapterPosition]
            binding.tvName.text = car.name
            binding.tvOpis.text = car.opis
            binding.imgCar.loadImage(car.image!!)


            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }
}

