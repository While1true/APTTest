package com.example.annotation.Base;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

/**
 * Created by ck on 2017/11/11.
 */

public interface Iprocessor {
    public void process(RoundEnvironment roundEnvironment, Element typeElement, Filer mfFiler, Elements elements, Messager messager);
}
