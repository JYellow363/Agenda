package pe.edu.upc.agenda

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact(
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val telephone: String) {

}