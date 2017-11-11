package com.example.annotation;

import com.example.annotation.Base.Iprocessor;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

/**
 * Created by ck on 2017/11/11.
 */

public class UtilProcessor implements Iprocessor {

    @Override
    public void process(RoundEnvironment roundEnvironment, Element element, Filer mfFiler, Elements elements, Messager messager) {
        TypeSpec.Builder typeSpec=TypeSpec.classBuilder(element.getAnnotation(Util.class).value())
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc("@eghejhnfmf")
                ;

        MethodSpec methodSpec=MethodSpec.methodBuilder("getUtils")
                .addModifiers(Modifier.PUBLIC,Modifier.STATIC)
                .returns(String.class)
                .addParameter(String.class,"name")
                .addCode("return name+\"123\";").build();

        typeSpec.addMethod(methodSpec);
        messager.printMessage(Diagnostic.Kind.NOTE,element.toString());
        JavaFile javaFile=JavaFile.builder(elements.getPackageOf(element).toString(),typeSpec.build()).build();
        try {
            javaFile.writeTo(mfFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
