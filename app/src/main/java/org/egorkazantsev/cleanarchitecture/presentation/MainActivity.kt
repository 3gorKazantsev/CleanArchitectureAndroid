package org.egorkazantsev.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.egorkazantsev.cleanarchitecture.R
import org.egorkazantsev.cleanarchitecture.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)

        val dataTextView: TextView = findViewById(R.id.data_TextView)
        val receiveButton: Button = findViewById(R.id.receive_Button)
        val dataEditText: EditText = findViewById(R.id.data_EditText)
        val sendButton: Button = findViewById(R.id.send_Button)

        viewModel.resultLiveData.observe(this) {
            dataTextView.text = it
        }
        viewModel.userLiveData.observe(this) {
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