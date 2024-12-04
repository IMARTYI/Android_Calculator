package com.example.calculator;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.nio.Buffer;

public class TranslationTest {
    Translate translate;
    private String api = "AIzaSyAfBLO6C0-BSE2TgQk_V3bKqrj0hpgzgfI";
    public TranslationTest(){

        String text  = "Hello my name is David";
        String targetLan = "es"; // Spanish Code
        String sourceLan  = "en"; // English Code

        this.translate = TranslateOptions.newBuilder().setApiKey(api).build().getService();

         Translation translation = translate.translate(
                 text, // Input text
                 Translate.TranslateOption.targetLanguage(targetLan), // Target Language
                 Translate.TranslateOption.sourceLanguage(sourceLan) // Source
         );

         String translatedText = translation.getTranslatedText(); // handle Response
         System.out.println(translatedText);
        }
    public static void main(String[] args) {
        new TranslationTest();
    }

    }

