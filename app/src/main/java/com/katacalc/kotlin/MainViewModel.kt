package com.katacalc.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var formula: MutableLiveData<String> = MutableLiveData()
    private var result: MutableLiveData<String> = MutableLiveData()

    private var builtFormula: String? = null

    fun getFormula(): LiveData<String> = formula

    fun getResult(): LiveData<String> = result

    fun operatorPressed(operation: String) {

        builtFormula = if (builtFormula == null) {
            operation
        } else {
            builtFormula + operation
        }

        updateFormulaDisplay()
    }

    fun numberPressed(number: Int) {

        builtFormula = if (builtFormula == null) {
            "$number"
        } else {
            builtFormula + "$number"
        }

        updateFormulaDisplay()
    }

    fun handleEquals() {
        updateResultDisplay()
    }

    fun handleClear() {
        builtFormula = ""
        updateFormulaDisplay()
    }

    private fun updateFormulaDisplay() {
        formula.value = builtFormula
    }

    private fun updateResultDisplay() {

        if (builtFormula == null) {
            result.value = "0"
            return
        }

        if (builtFormula!!.length < 2) {
            result.value = builtFormula
            return
        }

        val parts = builtFormula?.split("+")
        val left = parts?.get(0)?.toInt() ?: 0
        val right = parts?.get(1)?.toInt() ?: 0

        result.value = (left + right).toString()
    }
}