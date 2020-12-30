package utilities.generalUtilities;
import step_definitions.initalStep.ParamControl;
import utilities.api.APIAuthorization;
import utilities.dictionary.DirectoryType;
import utilities.exeptions.NullParamException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Git {
    private static String strDirectory;
    private static Path directory, repositoryPath;

    private static void setDirectory(ParamControl paramControl) {
        try{
            strDirectory = (String)paramControl.getParam("path");
            directory = Paths.get(strDirectory);
        }catch (NullParamException nprE){
            System.out.println("setDirectory");
        }
        // repositoryPath = Paths.get(test + "/.git");

    }

   protected static Path getDirectories(ParamControl paramControl , DirectoryType directoryType)  {
        if (directoryType == DirectoryType.directory && directory == null) {
            setDirectory(paramControl);
            return directory;
        } else if (directoryType == DirectoryType.directory) return directory;

        if (directoryType == DirectoryType.repositoryPath && repositoryPath == null && directory != null){

            return repositoryPath = Paths.get(strDirectory + "/.git");
        } else if (directoryType == DirectoryType.repositoryPath && repositoryPath != null) return repositoryPath;
        return null;
    }

/*    protected static void initAndAddFile(ParamControl paramControl) throws IOException, InterruptedException, NullParamException {

        Files.createDirectories(getDirectories(paramControl, "directory"));
        if (!Files.exists(repositorypath))
            gitInit(directory);

        Files.write(directory.resolve("token.txt"), APIAuthorization.getToken().getBytes());
        gitStage(directory);
        gitCommit(directory, "Add token.txt");
    }*/

/*    // example of usage
    protected static void cloneAndAddFile() throws IOException, InterruptedException {
        String originUrl = "https://github.com/Crydust/TokenReplacer.git";
        Path directory = Paths.get("c:/temp/TokenReplacer");
        gitClone(directory, originUrl);
        Files.write(directory.resolve("example.txt"), new byte[0]);
        gitStage(directory);
        gitCommit(directory, "Add example.txt");
        gitPush(directory);
    }*/

/*    protected static void gitInit(ParamControl paramControl) throws IOException, InterruptedException, NullParamException {
        runCommand(getDirectories(paramControl, "directory"), "git", "init");
    }*/
/*    protected static void gitRemoteAdd(Path directory) throws IOException, InterruptedException {
        runCommand(directory, "git", "remote", "add", "Token", "URL");
    }*/




    protected static void gitPush(ParamControl paramControl) throws IOException, InterruptedException {
      //  runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "push", "-u", "origin", "main");
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "push");
    }

    protected static void gitAdd(ParamControl paramControl) throws IOException, InterruptedException {
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "add", "-A");
    }
    protected static void gitCommit(ParamControl paramControl, String message) throws IOException, InterruptedException {
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "commit", "-m", message);
    }
    protected static void gitPull(ParamControl paramControl) throws IOException, InterruptedException {
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "pull");
    }
    protected static void gitInit(ParamControl paramControl) throws IOException, InterruptedException {
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "init");
    }
    protected static void gitRemoteAdd(ParamControl paramControl) throws IOException, InterruptedException {
        runCommand(getDirectories(paramControl, DirectoryType.directory), "git", "remote", "add", "Token", "https://github.com/cucamburs/Token.git");

    }




/*    protected static void gitCommit(Path directory, String message) throws IOException, InterruptedException {
        runCommand(directory, "git", "commit", "-m", message);
    }

    protected static void gitPush(Path directory) throws IOException, InterruptedException {
        runCommand(directory, "git", "push");
    }

    protected static void gitClone(Path directory, String originUrl) throws IOException, InterruptedException {
        runCommand(directory.getParent(), "git", "clone", originUrl, directory.getFileName().toString());
    }*/

    protected static void runCommand(Path directory, String... command) throws IOException, InterruptedException {
        Objects.requireNonNull(directory, "directory");
        if (!Files.exists(directory)) {
            throw new RuntimeException("can't run command in non-existing directory '" + directory + "'");
        }
        ProcessBuilder pb = new ProcessBuilder()
                .command(command)
                .directory(directory.toFile());
        Process p = pb.start();
        StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
        StreamGobbler outputGobbler = new StreamGobbler(p.getInputStream(), "OUTPUT");
        outputGobbler.start();
        errorGobbler.start();
        int exit = p.waitFor();
        errorGobbler.join();
        outputGobbler.join();
        if (exit != 0) {
            throw new AssertionError(String.format("runCommand returned %d", exit));
        }
    }

    private static class StreamGobbler extends Thread {

        private final InputStream is;
        private final String type;

        private StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(type + "> " + line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}