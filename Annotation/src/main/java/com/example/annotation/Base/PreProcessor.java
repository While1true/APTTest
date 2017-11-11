package com.example.annotation.Base;

import com.example.annotation.Base.Iprocessor;
import com.example.annotation.Util;
import com.example.annotation.UtilProcessor;
import com.google.auto.service.AutoService;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by ck on 2017/11/11.
 */

@AutoService(javax.annotation.processing.Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"com.example.annotation.Util"})
public class PreProcessor extends AbstractProcessor {
    private Filer mfFiler;
    private Elements elements;
    private Messager messager;
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        mfFiler=processingEnv.getFiler();
        elements=processingEnv.getElementUtils();
        messager=processingEnv.getMessager();
        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(Util.class);
        for (Element element : elementsAnnotatedWith) {
            System.out.println(element.getAnnotation(Util.class).value());
            new UtilProcessor().process(roundEnvironment, element, mfFiler, elements, messager);
        }
        return true;
    }
}
