package com.mentor.helloUniverse

object TestStyle {
    fun tdd(tddScope: TDD.() -> Unit) {
        TDD().tddScope()
    }

    fun bdd(bddScope: BDD.() -> Unit) {
        BDD().bddScope()
    }

    /**
     * use AAA - not specific to TDD
     */
    class TDD {
        fun arrange(arrangeScope: Arrange.() -> Unit) {
            Arrange().arrangeScope()
        }

        class Arrange {
            fun act(actScope: Act.() -> Unit) {
                Act().actScope()
            }
        }

        class Act() {
            fun assertion(assertScope: () -> Unit) {
                assertScope()
            }
        }
    }

    class BDD {
        fun given(details: String, givenScope: Given.() -> Unit) {
            println("given $details")
            Given().givenScope()
        }

        class Given {
            fun whenever(details: String, whenScope: When.() -> Unit) {
                println("when $details")
                When().whenScope()
            }
        }

        class When {
            fun then(details: String, thenScope: () -> Unit) {
                println("then $details")
                thenScope()
            }
        }
    }
}