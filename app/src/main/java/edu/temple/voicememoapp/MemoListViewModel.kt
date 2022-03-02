package edu.temple.voicememoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MemoListViewModel : ViewModel(){
    private val memolist by lazy{
        MemoList()
    }

    private val memolivelist by lazy {
        MutableLiveData<MemoList>()
    }

    fun setMemoList(_memoList : MemoList){
        memolist.setMemos(_memoList)
        this.memolivelist.value = memolist
    }

    fun addMemo(_memo : Memo){
        memolist.addMemo(_memo)
        this.memolivelist.value = memolist
    }

    fun removeMemo(index : Int){
        memolist.removeMemo(index)
        this.memolivelist.value = memolist
    }

    fun getListToObserve() : LiveData<MemoList>{
        return memolivelist
    }

    fun getMemoList(): MemoList{
        return memolist
    }



}