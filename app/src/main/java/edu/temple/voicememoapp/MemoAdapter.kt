package edu.temple.voicememoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoAdapter(_context: Context, memoList : MemoList, onClick: (Memo) -> Unit ) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {
    class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.findViewById<TextView>(R.id.titleView)
        val timeInfo = itemView.findViewById<TextView>(R.id.infoTextView)
        val playButton = itemView.findViewById<ImageButton>(R.id.playButton)

        fun bind(memo : Memo, onClick : (Memo) -> Unit){
            titleTextView.text = memo.title
            timeInfo.text = memo.temp
            playButton.setOnClickListener{onClick(memo)}
        }
    }

    val context = _context
    val memoList = memoList
    val onClick = onClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.memo, parent, false)
        return MemoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList.getMemo(position), onClick)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }
}