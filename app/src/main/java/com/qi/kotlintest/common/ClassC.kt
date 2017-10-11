package com.qi.kotlintest.common

/**
 * Created by Soumen on 12-09-2017.
 */
open class ClassA (aI: Int, bI: Int) {

    private var aI: Int
    private var bI: Int

    init {
        this.aI = aI
        this.bI = bI
    }

    open fun displayVal() {
        println("Values of ClassA ${aI} and ${bI}")
    }
}

open class ClassB(aI: Int, bI:Int, cI: Int): ClassA(aI, bI) {

    private var cI: Int

    init {
        this.cI = cI
    }

    override fun displayVal() {
        super.displayVal()
        println("Values of ClassB ${cI}")
    }
}

interface InterfaceD {
    fun displayVal() = println("InterfaceD's displayVal()")
}

interface InterfaceE {
    fun displayVal() = println("InterfaceE's displayVal()")
    fun exclusiveEMethod()
}

open class ClassF {

    private var eI: Int
    private var eJ: Int

    init {
        eI = 1947
        eJ = 2017
    }

    open fun justAMethod() = println("This is just a method")
}

public class ClassC(aI: Int, bI: Int, cI: Int, dI: Int): ClassB(aI, bI, cI), InterfaceD, InterfaceE {

    private var dI: Int

    init {
        this.dI = dI
    }

    override fun displayVal() {
        super<ClassB>.displayVal()
        super<InterfaceD>.displayVal()
        super<InterfaceE>.displayVal()
        println("Values of ClassC ${dI}")
    }

    override fun exclusiveEMethod() {
        println("This was in an interface, so forcefully overridden")
    }
}