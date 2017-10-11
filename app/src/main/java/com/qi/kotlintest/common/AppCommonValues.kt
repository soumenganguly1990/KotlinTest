package com.qi.kotlintest.common

/**
 * Created by Soumen on 12-09-2017.
 */
public class AppCommonValues {

    companion object {

        fun executeClassA() {
            var primaryTest = MultipleConstructors("SAM")
            primaryTest.displayVals()
            primaryTest = MultipleConstructors("Tan", 1011)
            primaryTest.displayVals()
            primaryTest = ExtendedMultipleConstructor("Lam", 9876, "QI Office @Singapore")
            primaryTest.displayVals()
            primaryTest.testExtendedMultipleConstructor()
        }

        fun checkInheritance() {
            var classC = ClassC(10, 30, 20, 40)
            classC.displayVal()
            classC.exclusiveEMethod()
        }
    }
}