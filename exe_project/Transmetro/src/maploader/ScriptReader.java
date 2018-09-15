/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maploader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;


/**
 *
 * @author rick
 */
 public class ScriptReader {
 
    /**
     * Archivo JavaScript.
     */
    private static final File SCRIPT = new File("src/main/resources/test.js");
    /**
     * Motor de ejecuci&oacute;n JavaScript.
     */
    private static final ScriptEngine ENGINE = new ScriptEngineManager().
        getEngineByName("javascript");
 
    public static void main(String[] args) {
        try {
            // Leemos el archivo JavaScript.
            FileReader fr = new FileReader(SCRIPT);
             
            Bindings bindings = new SimpleBindings();
            bindings.put("pNumero1", 3);
            bindings.put("pNumero2", 5);
             
            // Ejecutamos el JavaScript
            Object result = ENGINE.eval(fr, bindings);
 
            // Imprimimos el retorno.
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
    }
}
