package org.egorkazantsev.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import org.egorkazantsev.cleanarchitecture.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView: TextView = findViewById(R.id.data_TextView)
        val receiveButton: Button = findViewById(R.id.receive_Button)
        val dataEditText: EditText = findViewById(R.id.data_EditText)
        val sendButton: Button = findViewById(R.id.send_Button)

        viewModel.resultLiveData.observe(this) {
            dataTextView.text = it
        }

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            viewModel.save(text)
        }

        receiveButton.setOnClickListener {
            viewModel.receive()
        }
    }
}