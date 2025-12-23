package type.aliases

import org.w3c.dom.Node

typealias NodeSet = Set<Node>

class A{
    inner class B
}

typealias InnerOfA = A.B

typealias Predicate<T> = (T) -> Boolean
inline fun foo(p: Predicate<Int>) = p(42)

