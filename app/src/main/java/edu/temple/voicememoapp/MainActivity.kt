package edu.temple.voicememoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), Dashboard.DashboardInterface{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Voice Memo's"

    }

    override fun addMemo() {
        Navigation.findNavController(findViewById(R.id.fragmentNavigation))
            .navigate(R.id.action_dashboard_to_recordingFragment)
    }
}