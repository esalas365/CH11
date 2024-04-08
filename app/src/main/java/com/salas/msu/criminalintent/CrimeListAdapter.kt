package com.salas.msu.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.salas.msu.criminalintent.databinding.ListItemCrimeBinding
import java.text.SimpleDateFormat
import java.util.Locale

class CrimeHolder(
    val binding: ListItemCrimeBinding
): RecyclerView.ViewHolder(binding.root) {
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date) as TextView



    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()
        dateTextView.text = SimpleDateFormat("EEEE, LLL d, yyyy", Locale.US).format(crime.date)


        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else{
            View.GONE
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
         holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        }

        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size


    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice) 1 else 0
    }
}




