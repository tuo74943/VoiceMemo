package edu.temple.voicememoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class AddMemoFragment : Fragment() {

    lateinit var layout : View
    val memoListViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MemoListViewModel::class.java)
    }

    val titleEditText : EditText by lazy {
        layout.findViewById(R.id.titleEditText)
    }
    val infoEditText : EditText by lazy {
        layout.findViewById(R.id.infoEditText)
    }

    val addMemoButton : Button by lazy {
        layout.findViewById(R.id.addMemmoButton)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_add_memo, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMemoButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val info = infoEditText.text.toString()

            memoListViewModel.addMemo(Memo(title, info))

            findNavController().navigate(R.id.action_recordingFragment_to_dashboard)
        }
    }

}