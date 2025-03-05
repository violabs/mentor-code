package com.mentor.helloUniverse

/**
 * A singleton to contain our test style code.
 * The class structure to make it nested sets up methods with
 * return object that change the scope of the target. Example:
 * [TestStyle.TDD.Arrange.act] -> [TestStyle.TDD.Act]
 * [TestStyle.TDD.Act.assertion] -> final assertion.
 */
object TestStyle {
    /**
     * This supplies a code block that has the scope changed to have
     * the newly created [TDD] object as the target (keyword `this` changes to
     * the object in scope)
     */
    fun tdd(tddScope: TDD.() -> Unit) {
        TDD().tddScope()
    }

    /**
     * This supplies a code block that has the scope changed to have
     * the newly created [BDD] object as the target (keyword `this` changes to
     * the object in scope)
     */
    fun bdd(bddScope: BDD.() -> Unit) {
        BDD().bddScope()
    }

    /**
     * use AAA - not specific to TDD
     */
    class TDD {
        /**
         * Provide the scope as the [Arrange] object
         */
        fun arrange(arrangeScope: Arrange.() -> Unit) {
            Arrange().arrangeScope()
        }

        class Arrange {
            /**
             * Provide the scope as the [Act] object
             */
            fun act(actScope: Act.() -> Unit) {
                Act().actScope()
            }
        }

        class Act() {
            /**
             * Provide an runnable scope (normal scope)
             */
            fun assertion(assertScope: () -> Unit) {
                assertScope()
            }
        }
    }

    class BDD {
        /**
         * Provide the scope as the [Given] object
         */
        fun given(details: String, givenScope: Given.() -> Unit) {
            println("given $details")
            Given().givenScope()
        }

        class Given {
            /**
             * Provide the scope as the [When] object
             */
            fun whenever(details: String, whenScope: When.() -> Unit) {
                println("when $details")
                When().whenScope()
            }
        }

        class When {
            /**
             * Provide an runnable scope (normal scope)
             */
            fun then(details: String, thenScope: () -> Unit) {
                println("then $details")
                thenScope()
            }
        }
    }
}