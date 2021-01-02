package utilities.generalUtilities;

import step_definitions.initalStep.ParamControl;
import utilities.dictionary.DirectoryType;
import utilities.exeptions.NotInitializationTokenException;
import utilities.exeptions.NullParamException;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GitControl extends Git{

    public static void getConfigEmail(){
        try{
            gitConfigEmail(Paths.get("/home/tester/.ssh"));
        }catch (Exception e) {
            System.out.println("initToken");
        }
    }

    public static void getTestConnection(){
        try{
            githubTestConnection(Paths.get("/home/tester/.ssh"));
        }catch (Exception e) {
            System.out.println("initToken");
        }
    }

    public static void getConfigName(){
        try{
            gitConfigName(Paths.get("/home/tester/.ssh"));
        }catch (Exception e) {
            System.out.println("initToken");
        }
    }

    public static void getInitToken(ParamControl paramControl){
        try{
            gitInit(paramControl);
        }catch (Exception e) {
            System.out.println("initToken");
        }
    }

    public static void addToken(ParamControl paramControl)  {
        try{
            gitAdd(paramControl);
        }catch (Exception e) {
            System.out.println("addToken");
        }

    }
    public static void commitToken(ParamControl paramControl, String text)  {
        try{
            gitCommit(paramControl, text);
        }catch (Exception e) {
            System.out.println("commitToken");
        }

    }
    public static void gitRemoteAddRepo(ParamControl paramControl){
        try{
            gitRemoteAdd(paramControl);
        }catch (Exception e) {
            System.out.println("addToken");
        }
    }
    public static void gitSetRepo(ParamControl paramControl){
        try{
            gitSet(paramControl);
        }catch (Exception e) {
            System.out.println("SetRepo");
        }
    }

    public static void pushToken(ParamControl paramControl) {
        try{
            gitPush(paramControl);
        }catch (Exception e) {
            System.out.println("pushToken");
        }

    }
    public static void pushForceToken(ParamControl paramControl) {
        try{
            gitPushForce(paramControl);
        }catch (Exception e) {
            System.out.println("pushToken");
        }

    }

    public static Path getDirectory(ParamControl paramControl, DirectoryType directoryType){
        return getDirectories(paramControl, directoryType);
    }

    public String readToken(ParamControl paramControl) throws NotInitializationTokenException {


        try{
          return readLocalToken(paramControl);

        }catch (FileNotFoundException e){
        if(getDirectories(paramControl, DirectoryType.repositoryPath) == null){
            throw new NotInitializationTokenException("Not Initialization Token. Read Framework installation guide");
        }

        }

        // чтение и проверка локального token
        // если локальный token не работает, то загрузить token из Github и обновить файл локального Token
        // после прочтения локальнорго Token удалить его

        return "";
    }

    private String readLocalToken(ParamControl paramControl) throws FileNotFoundException {
        // Чтение локального Token

        StringBuilder token = new StringBuilder();
        Path fileName = getDirectories(paramControl, DirectoryType.directory);
        File file = new File("" +fileName + "/token.txt");

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){

                token.append(scanner.nextLine());
            }
            token = new StringBuilder(token.toString().trim());


        return token.toString();
    }
}
