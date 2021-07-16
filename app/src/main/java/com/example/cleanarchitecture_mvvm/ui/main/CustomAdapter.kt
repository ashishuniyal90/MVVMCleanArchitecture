package com.example.cleanarchitecture_mvvm.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture_mvvm.R
import com.example.domain.model.User

class CustomAdapter :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var dataSet: MutableList<User> = mutableListOf()

    fun setData(data: List<User>) {
        this.dataSet.clear()
        this.dataSet.addAll(data)
        notifyDataSetChanged()
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textview)
        val textView1: TextView = view.findViewById(R.id.textview1)
        val textView2: TextView = view.findViewById(R.id.textview2)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_user, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        dataSet[position].run {
            viewHolder.textView.text = userId
            viewHolder.textView1.text = "$firstname $lastname"
            viewHolder.textView2.text = email
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}