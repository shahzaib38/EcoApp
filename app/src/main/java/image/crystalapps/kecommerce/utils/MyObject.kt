package image.crystalapps.kecommerce.utils

class MyObject<O:Model> {


    lateinit var foo: O

    constructor(foo:O) {
        this.foo = foo
    }



}