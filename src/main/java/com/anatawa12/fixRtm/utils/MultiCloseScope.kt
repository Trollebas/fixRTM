package com.anatawa12.fixRtm.utils

import java.io.Closeable

interface MultiCloseScope {
    fun <C : Closeable>C.closer(): C
}

inline fun <T>closeScope(block: MultiCloseScope.() -> T): T {
    val closeables = mutableListOf<Closeable>()
    var cause: Throwable? = null
    try {
        val scope = object : MultiCloseScope {
            override fun <C : Closeable>C.closer(): C {
                closeables += this
                return this
            }
        }
        return scope.block()
    } catch (e: Throwable) {
        cause = e
        throw e
    } finally {
        for (closeable in closeables) {
            try {
                closeable.close()
            } catch (closeException: Throwable) {
                if (cause != null)
                    cause.addSuppressed(closeException)
                else
                    cause = closeException
            }
        }
    }
}
