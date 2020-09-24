package pe.edu.upc.agenda

import androidx.room.*

@Dao
interface ContactDao {

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Insert
    fun insert(vararg contacts: Contact)

    @Delete
    fun delete(vararg contacts: Contact)

    @Update
    fun update(vararg contacts: Contact)
}