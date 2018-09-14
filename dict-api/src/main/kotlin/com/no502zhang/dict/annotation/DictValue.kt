package com.no502zhang.dict.annotation

@Target(AnnotationTarget.PROPERTY)
annotation class DictValue(val value: String) {
}