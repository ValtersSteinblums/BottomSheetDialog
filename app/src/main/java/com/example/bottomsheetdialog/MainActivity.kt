package com.example.bottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.bottomsheetdialog.dialogs.MyBottomSheetDialog

class MainActivity : AppCompatActivity(), MyBottomSheetDialog.BottomSheetListener {
    private lateinit var openDialogButton: Button
    private lateinit var textViewButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openDialogButton = findViewById(R.id.button_open_dialog)
        textViewButton = findViewById(R.id.text_view)

        openDialogButton.setOnClickListener {
            val myBottomSheetDialog = MyBottomSheetDialog()
            myBottomSheetDialog.show(supportFragmentManager, "Dialog")
        }
    }

    override fun onButtonClicked(input: String) {
        textViewButton.text = input
    }
}