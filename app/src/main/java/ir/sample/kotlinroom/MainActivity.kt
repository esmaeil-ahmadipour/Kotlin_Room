package ir.sample.kotlinroom

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ir.sample.kotlinroom.roomLayer.AppDatabase
import ir.sample.kotlinroom.roomLayer.dataAccessObjects.UserDao
import ir.sample.kotlinroom.roomLayer.entities.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var alertMessage = "";
    var userId: Int = 0
    val context: Context = this;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listeners()
    }


    private fun listeners() {
        // OnClick btn_main_confirm :
        /*
           1-Check Validate Data ,
           2-Show AlertDialog For Errors ,
           3-Send Data To Database & Intent Other Activity
       */
        btn_main_confirm.setOnClickListener {
            if (validator()) {
                val name: String = edt_main_name.text.toString()
                val email: String = edt_main_email.text.toString()
                val number: String = edt_main_number.text.toString()
                sendData(name, email, number)
                intentLoadData()
            } else {
                val invalidatedAlert = AlertDialog.Builder(context)
                invalidatedAlert.setTitle(context.resources.getString(R.string.string_alert_title))

                invalidatedAlert.setMessage(alertMessage)
                invalidatedAlert.setNeutralButton(context.resources.getString(R.string.string_confirm) ,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, p1: Int) {
                            dialog?.dismiss();
                        }
                    })
                invalidatedAlert.create().show()
            }
        }
    }

    //Check Validate Data Entries And Set Acceptance for them.
    private fun validator(): Boolean {
        var validate = true

        if (edt_main_name.text.toString() == "") {
            validate = false
            alertMessage = context.resources.getString(R.string.string_alert_edtUsername)
        }

        if (((edt_main_email.text.toString() != "") && !(edt_main_email.text.toString().contains("@"))))
        {validate = false
            alertMessage =context.resources.getString(R.string.string_alert_edtEmail)
        }


        if (edt_main_number.text.toString() == "")
        { validate = false
            alertMessage = context.resources.getString(R.string.string_alert_edtNumber)
        }

        return validate
    }

    //Pass Received Data To New UserEntity Object And Use This Object To Insert Data.
    private fun sendData(name: String, email: String, number: String) {
        val userData: UserDao = AppDatabase.getInstance(context).user()
        val user = UserEntity(userId, name, email, number)
        userData.insert(user)
    }

    // Intent to LoadDataActivity
    private fun intentLoadData() {
        val loadData = Intent(context, LoadDataActivity::class.java)
        startActivity(loadData)
    }
}




