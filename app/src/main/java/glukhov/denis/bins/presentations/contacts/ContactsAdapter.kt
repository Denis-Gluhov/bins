package glukhov.denis.bins.presentations.contacts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import glukhov.denis.bins.R
import kotlinx.android.synthetic.main.item_contact.view.*
import java.util.*

class ContactsAdapter(
    private val listener: Listener
): RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    private var items: MutableList<Contact> = ArrayList()

    interface Listener {
        fun onClickItem(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: List<Contact>) {
        items.clear()
        items.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(items[position])
        holder.view.llContact.setOnClickListener { listener.onClickItem(position) }
    }

    inner class ContactViewHolder(
        val view: View,
        private val context: Context
    ): RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Contact) {
            view.tvContact.text = "${item.name}, ${item.age}"
            view.tvMsg.text = item.msg
            view.tvTime.text = item.time

            Glide.with(context)
                .load(replace(item.foto))
                .apply(
                    RequestOptions()
                        .placeholder(ContextCompat.getDrawable(context, R.drawable.ic_launcher_background))
                        .error(ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)))
                .into(view.ivFoto)
        }

        private fun replace(url: String): String {
            return url.replace('@', 'm') + "_"
        }

    }

}