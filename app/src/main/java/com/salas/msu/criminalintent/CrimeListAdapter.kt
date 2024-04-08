package com.salas.msu.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.salas.msu.criminalintent.databinding.ListItemCrimeBinding

/*class CrimeHolder(
    private val binding: ListItemCrimeBinding
): RecyclerView.ViewHolder(binding.root) {



    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()



        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


class CrimeListAdapter(private val crimes: List<Crime>): RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)

        return CrimeHolder(binding)
    }




    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        *//* holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        }*//*

        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size


    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) 1 else 0
    }
}*/

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ListItemCrimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        return CrimeHolder(parent)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) 1 else 0
    }
}

