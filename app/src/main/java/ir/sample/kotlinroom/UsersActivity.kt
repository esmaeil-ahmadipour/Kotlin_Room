package ir.sample.kotlinroom

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.sample.kotlinroom.roomLayer.AppDatabase
import ir.sample.kotlinroom.roomLayer.entities.UserEntity
import ir.sample.kotlinroom.utils.MainAdapter
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.content_users.*

class UsersActivity : AppCompatActivity() {
val context :Activity =this

//
    var alertMessage = "";
    var userId: Int = 0
    lateinit var db:AppDatabase;
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        db=AppDatabase.getInstance(context)
        viewInitializer();
        listeners()

    }

    override fun onRestart() {
        super.onRestart()
        loadUsers()
    }

    private fun listeners() {
        // OnClick  Fab : fab_users_main
        /*
        */
        fab_users_main.setOnClickListener {
            intentLoadData()
        }
    }

    private fun viewInitializer() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rcv_contentUsers_main.itemAnimator=DefaultItemAnimator();
        rcv_contentUsers_main.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL, false)
        loadUsers()
    }

    private fun getUsers() : List<UserEntity>{
        val usersList = db.user().getAll()
        return usersList
    }
    private fun loadUsers(){
        val usersList =getUsers()
        val userAdapter = MainAdapter(context , usersList)
        rcv_contentUsers_main.adapter=userAdapter
    }
    // Intent to LoadDataActivity
    private fun intentLoadData() {
        val loadData = Intent(context, MainActivity::class.java)
        startActivity(loadData)
    }
}

















