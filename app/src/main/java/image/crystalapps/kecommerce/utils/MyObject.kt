package image.crystalapps.kecommerce.utils

import image.crystalapps.kecommerce.model.Model

class MyObject<O: Model> {


    lateinit var foo: O

    constructor(foo:O) {
        this.foo = foo
    }



}