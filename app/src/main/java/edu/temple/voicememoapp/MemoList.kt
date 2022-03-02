package edu.temple.voicememoapp

class MemoList{
    private val memos : MutableList<Memo> by lazy {
        ArrayList()
    }

    val size : Int get() = memos.size

    fun setMemos(memoList: MemoList){
        for(i in 0 until memoList.size){
            memos.add(memoList.getMemo(i))
        }
    }

    fun addMemo(memo: Memo){
        memos.add(memo)
    }

    fun removeMemo(index : Int){
        memos.removeAt(index)
    }

    fun getMemo(index : Int) : Memo{
        return memos[index]
    }
}