package edu.temple.voicememoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MemoListFragment : Fragment() {

    lateinit var layout : View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : MemoAdapter
    val memoList : ArrayList<Memo> by lazy {
        ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_memo_list, container, false)
        recyclerView = layout.findViewById(R.id.memoRecyclerView)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for(i in 0 .. 5){
            memoList.add(Memo("Rec:#${i+1}", "Time: ${i+1}"))
        }
        adapter = MemoAdapter(requireContext(), memoList, {memo : Memo -> onClick(memo)})
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    fun onClick(memo: Memo){
        //what do we want to do when the play button is pressed?
        Log.d("Memo OnClick", "we are pressing the play button on this memo ${memo.title}, ${memo.temp}")
    }

}