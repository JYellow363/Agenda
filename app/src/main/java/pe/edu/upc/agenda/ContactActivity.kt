package pe.edu.upc.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        btSave.setOnClickListener {
            val name = etName.text.toString()
            val telephone = etTelephone.text.toString()

            val contact = Contact(null, name, telephone)

            AppDatabase.getInstance(this).contactDao().insert(contact)

            finish()
        }
    }
}