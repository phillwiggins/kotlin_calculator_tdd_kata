package com.katacalc.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var formula: MutableLiveData<String> = MutableLiveData()
    private var result: MutableLiveData<String> = MutableLiveData()

    fun getFormula(): LiveData<String> = formula

    fun getResult(): LiveData<String> = result

    fun operatorPressed(operation: String) {
        // TODO
    }

    fun numberPressed(number: Int) {
        formula.value = "$number"
        result.value = "$number"
    }

    fun handleEquals() {
        // TODO
    }

    fun handleClear() {
        // TODO
    }
}