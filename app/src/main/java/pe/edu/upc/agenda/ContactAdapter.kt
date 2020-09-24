package pe.edu.upc.agenda

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_contact_edit.view.*
import kotlinx.android.synthetic.main.prototype_contact.*
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactPrototype(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bindTo(contact: Contact){
        itemView.tvName.text = contact.name
        itemView.tvTelephone.text = contact.telephone
    }
}

class ContactAdapter(val context: Context, private val contacts: List<Contact>,
                     private val cellClickListener: CellClickListener): RecyclerView.Adapter<ContactPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_contact, parent, false)
        return ContactPrototype(view)
    }

    override fun onBindViewHolder(holder: ContactPrototype, position: Int) {
        holder.bindTo(contacts[position])
        holder.itemView.setOnClickListener {
            val data = contacts[position]

            cellClickListener.onCellClickListener(data)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}