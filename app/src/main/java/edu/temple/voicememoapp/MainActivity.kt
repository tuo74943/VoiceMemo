package edu.temple.voicememoapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), Dashboard.DashboardInterface{

    val memoListViewModel by lazy {
        ViewModelProvider(this).get(MemoListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Voice Memo's"

        val memoList = MemoList()
        for(i in 0 .. 2){
            memoList.addMemo(Memo("Title ${i}", "info ${i}"))
        }

        memoListViewModel.setMemoList(memoList)

        requestAudioPermission()

    }

    fun requestAudioPermission(){
        if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.RECORD_AUDIO
                ), 1
            )
        }
    }

    override fun addMemo() {
        Navigation.findNavController(findViewById(R.id.fragmentNavigation))
            .navigate(R.id.action_dashboard_to_recordingFragment)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1){
            if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                finish()
            }
        }
    }
}