package com.qi.kotlintest.common

/**
 * Created by Soumen on 12-09-2017.
 */
open class MultipleConstructors constructor(name: String) {

    private var name: String
    private var id: Int
    private var add: String

    init {
        this.name = name
        id = 1001
        add = "Whatever address"
    }

    constructor(name: String, id: Int): this(name) {
        this.id = id
    }

    constructor(name: String, id: Int, add:String): this(name, id) {
        this.add = add
    }

    public fun displayVals() {
        println("Name: ${name}, ID: ${id} and Address: ${add}")
    }

    public fun displayVals(i: Int) {
        println("This is just an overloaded displayVals() function")
    }

    public fun testObject() {
        var obj = object {
            var x: Int = 50
            var y: Int = 60
        }
        println("The values are X: ${obj.x} and Y: ${obj.y}")
    }
}

class ExtendedMultipleConstructor(name: String): MultipleConstructors(name) {

    private var empId: Int
    private var company: String

    init {
        empId = 2001
        company = "QI"
        MultipleConstructors("Sam", 1001)
    }

    constructor(name: String, empId: Int): this(name) {
        this.empId = empId
        this.company = company
    }

    constructor(name: String, empId: Int, company: String): this(name, empId) {
        this.empId = empId
        this.company = company
    }

    fun testExtendedMultipleConstructor() {
        super.displayVals()
        super.displayVals(10)
        super.testObject()
        println("Extended class values EmpID: ${empId} and Company: ${company}")
    }
}