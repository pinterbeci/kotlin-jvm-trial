package generics

//instead of Java, Kotlin has declaration-site variance
//Kotlin has no wildcards

//Java Generic types 'invariant', what means List<String> is not subtype of List<Object>;
//If List<> were non-invariant this can happen:
/*
    List<String> strings = new ArrayList<>();

    List<Object> objects = strings; //BOOM does not compile regarding type-mismatch

    objects.add(1);

    strings.get(0); //ClassCastException, because the upper add() operation; I added an integer to a list, which stores Strings
 */


/*
//
Producer:

    Java:
    interface Collection<E> ... {
        void addAll(Collection<? extends E> items);
    }
    '? extends E' - restriction help to avoid the class cast exception. It determines the elements that can be added to the current collection
    //////////////////////////////
    Collection<? extends E> items -> the restriction ensures the E's safety read.
    The write operation does not enable, because of:
    'extends-bound' or 'upper-bound' or 'covariant', that means the <? extends E>. (PE from PECS) Producer Extends.

    Key is simple, I define one concrete type, which is 'E'. I don't know any of subtype.
    The inheritance hierarchy is unknown at this point, I mean the subtypes.
 */

/*
Consumer:
    interface Collection<E> ... {
        void addAll(Collection<? super E> items);
    }
    '? super E' - restriction know all 'parent classes'; There is no doubts regarding the type hierarchy, we know the last item perfectly in hierarchy.
     The caller will determine the 'E', and there is no doubt. Subclass of 'E' cannot add to.
 */

//class Wrapper<? extends T>
//Producer, I cannot the subtypes of 'T' type parameter.
//Produced == Returned (as output) !!!!
//The type parameter is used as an output only

//output means write

//T is a covariant type parameter
//'out' is called 'Variance annotation'
//'Wrapper' is covariant
class Wrapper<out T> {

    //Type parameter T is declared as 'out' but occurs in 'in' position in type T
    //fun consume(t: T){}
}

open class Base
class Derived : Base()


//Consumer
//Consumed = Taken (as input)
//The type parameter is used as an input only

//input means add

//'T2' type parameter is 'contravariant', what the 'in' did.
class Consumer<in T2> {
    fun add(item: T2) {
        TODO()
    }
}