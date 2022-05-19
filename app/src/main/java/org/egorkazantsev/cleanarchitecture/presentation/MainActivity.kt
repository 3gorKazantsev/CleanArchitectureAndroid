package org.egorkazantsev.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.egorkazantsev.cleanarchitecture.R
import org.egorkazantsev.cleanarchitecture.data.repository.UserRepositoryImpl
import org.egorkazantsev.cleanarchitecture.data.storage.sharedprefs.UserSharedPrefs
import org.egorkazantsev.cleanarchitecture.domain.model.User
import org.egorkazantsev.cleanarchitecture.domain.model.UserParam
import org.egorkazantsev.cleanarchitecture.domain.usecase.GetUserUseCase
import org.egorkazantsev.cleanarchitecture.domain.usecase.SaveUserUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(UserSharedPrefs(applicationContext))
    }

    private val getUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserUseCase(userRepository)
    }
    private val saveUserUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserUseCase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView: TextView = findViewById(R.id.data_TextView)
        val receiveButton: Button = findViewById(R.id.receive_Button)
        val dataEditText: EditText = findViewById(R.id.data_EditText)
        val sendButton: Button = findViewById(R.id.send_Button)

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val param = UserParam(text)
            val result = saveUserUseCase.execute(param)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val user: User = getUserUseCase.execute()
            dataTextView.text = "${user.firstName} ${user.lastName}"
        }

    }
}