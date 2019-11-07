package com.weber.knowledgegame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_knowledge.view.*

/*
 * Created on 2019-11-06
 * @author YWeber
 */
class ListKnowledgeAdapter(
    private val knowledgeList: List<String>,
    private val clickItem: (name: String) -> Unit
) :
    RecyclerView.Adapter<ListKnowledgeAdapter.ListKnowledgeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKnowledgeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_knowledge, parent, false)
        return ListKnowledgeHolder(view)
    }

    override fun getItemCount(): Int = knowledgeList.size

    override fun onBindViewHolder(holder: ListKnowledgeHolder, position: Int) {
        holder.bind(knowledgeList[position], clickItem)
    }


    class ListKnowledgeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(name: String, click: (String) -> Unit) {
            itemView.tvName.text = name
            itemView.tvName.setOnClickListener {
                click(name)
            }
        }
    }
}