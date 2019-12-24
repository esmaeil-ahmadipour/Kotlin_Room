package ir.sample.kotlinroom

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ir.sample.kotlinroom.roomLayer.AppDatabase
import ir.sample.kotlinroom.roomLayer.entities.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        test();
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun test() {
        val db: AppDatabase = AppDatabase.getInstance(context)
// Test : Insert New Record To Database
/*
        val userSampleInsert = UserEntity("Admin", "Admin@gmail.com", "09112223344")
        db.user().insert(userSampleInsert)
        val dbGetAllData =  db.user().getAll();
*/


// Test : Update One Record From Database
/*
        val userSampleInsert = UserEntity(1,"John","John@gmail.com","09012223344")
        db.user().update(userSampleInsert)
        val dbGetAllData =  db.user().getAll();
*/

        val dbGetData =  db.user().getById(1);

    }
}
