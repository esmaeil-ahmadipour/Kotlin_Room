package ir.sample.kotlinroom

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.sample.kotlinroom.roomLayer.AppDatabase
import ir.sample.kotlinroom.roomLayer.entities.UserEntity
import kotlinx.android.synthetic.main.activity_load_data.*


class LoadDataActivity : AppCompatActivity() {
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_data)
        loadingData()
    }

    //GetAllData from Database And Show Result inside a TextView
    private fun loadingData() {
        val db: AppDatabase = AppDatabase.getInstance(context)
        val dbGetAllData = db.user().getAll();
        val builder: StringBuilder = StringBuilder()
        for (item: UserEntity in dbGetAllData) {
            builder.append(
                        item.id,
                " , " + item.name,
                " , " + item.email,
                " , " + item.number,
                "\n"
            )
        }
        txt_load_data.setText(builder.toString())
    }
}


