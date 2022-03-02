package edu.temple.voicememoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        for(i in 0 .. 10){
            memoList.addMemo(Memo("Title ${i}", "info ${i}"))
        }

        memoListViewModel.setMemoList(memoList)

    }

    override fun addMemo() {
        Navigation.findNavController(findViewById(R.id.fragmentNavigation))
            .navigate(R.id.action_dashboard_to_recordingFragment)
    }
}