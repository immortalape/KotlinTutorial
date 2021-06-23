package com.example.kotlintutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.TestRecyclerViewAdapter.TestViewHolder

class TestRecyclerViewAdapter : RecyclerView.Adapter<TestViewHolder>() {

    private var list = emptyList<ListModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.test_view_holder, parent, false)
        return TestViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = list.size

    fun setData(list: List<ListModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.test_vh_name)
        private val age = itemView.findViewById<TextView>(R.id.test_vh_age)

        fun bind(item: ListModel) {
            name.text = item.name
            age.text = item.age.toString()
        }
    }
}
