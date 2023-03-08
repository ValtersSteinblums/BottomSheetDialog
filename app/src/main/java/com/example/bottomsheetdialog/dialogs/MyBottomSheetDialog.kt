package com.example.bottomsheetdialog.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bottomsheetdialog.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialog : BottomSheetDialogFragment() {
    private lateinit var listener: BottomSheetListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        val button1: Button = view.findViewById(R.id.button_1)
        val button2: Button = view.findViewById(R.id.button_2)

        button1.setOnClickListener {
            listener.onButtonClicked("Button 1 clicked")
            dismiss()
        }

        button2.setOnClickListener {
            listener.onButtonClicked("Button 2 clicked")
            dismiss()
        }

        return view
    }

    interface BottomSheetListener {
        fun onButtonClicked(input: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BottomSheetListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " you must implement bottomSheetListener")
        }
    }
}