package pe.edu.upc.agenda

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_contact.view.*
import kotlinx.android.synthetic.main.activity_contact_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.prototype_contact.*
import kotlinx.android.synthetic.main.prototype_contact.view.*

class MainActivity : AppCompatActivity(), CellClickListener {

    lateinit var contacts: List<Contact>
    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadContacts()
        initViews()
    }

    override fun onResume() {
        super.onResume()
        loadContacts()
        initViews()
    }

    private fun loadContacts(){
        contacts = AppDatabase.getInstance(this).contactDao().getAll()
    }

    private fun initViews(){
        contactAdapter = ContactAdapter(this, contacts, this)
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)

        fabContact.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCellClickListener(data: Contact) {
        val intent = Intent(this, ContactEditActivity::class.java)
        intent.putExtra("name", data.name)
        intent.putExtra("telephone", data.telephone)
        intent.putExtra("uid", data.uid)
        startActivity(intent)
    }
}