package idioms

import kotlin.reflect.KClass

//in short reified retains the type information in the runtime
//this not works, cannot perform any operation on 'T' directly
//Type erasure -  at bellow the compiler shows an error 'Cannot use 'T' as reified type parameter. Use a class instead.'
//This error happens, because in the compile time, the compiler removes the type argument from the function call
/*fun <T> doSomething(value: T) {
    println("Doing something with type: ${T::class.simpleName}")  // Error
}*/

//for example, if I call this:
//doSomething<String>("Some String")

//the compiler removes the <String>
//and looks like tis doSomething("Some String")
//this is the Type Erasure
//In the runtime
//     println("Doing something with type: ${T::class.simpleName}")
//we cannot possibly know which type T stands for

//Java solution
fun <T: Any> doSomething(value: T, type: KClass<T>){
    println("Doing something with type: ${type.simpleName}")
}

//not so elegant, and verbose

//so this is when the reified is coming to the room
//reified modifier tells to the compiler please retain this type during the compile time
inline fun <reified T> doSomething2(value: T){
    println("Doing something with type: ${T::class.simpleName}")
}

/*
Decompiled two methods:
  public static final void doSomething(@NotNull Object value, @NotNull KClass type) {
      Intrinsics.checkNotNullParameter(value, "value");
      Intrinsics.checkNotNullParameter(type, "type");
      System.out.println("Doing something with type: " + type.getSimpleName());
   }

   // $FF: synthetic method
   public static final void doSomething2(Object value) {
      int $i$f$doSomething2 = false;
      Intrinsics.reifiedOperationMarker(4, "T");
      System.out.println("Doing something with type: " + Reflection.getOrCreateKotlinClass(Object.class).getSimpleName());
   }
 */

