package pe.edu.upc.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_contact_edit.*

class ContactEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_edit)
        etNameEdit.setText(intent.getStringExtra("name"))
        etTelephoneEdit.setText(intent.getStringExtra("telephone"))
        val uid = intent.getIntExtra("uid", 0)

            btEdit.setOnClickListener {
            val name = etNameEdit.text.toString()
            val telephone = etTelephoneEdit.text.toString()

            val contact = Contact(uid, name, telephone)
            AppDatabase.getInstance(this).contactDao().update(contact)

            finish()
        }
        btDelete.setOnClickListener {
            val name = etNameEdit.text.toString()
            val telephone = etTelephoneEdit.text.toString()

            val contact = Contact(uid, name, telephone)
            AppDatabase.getInstance(this).contactDao().delete(contact)

            finish()
        }
    }

}