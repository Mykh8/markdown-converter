import input.InputHandler;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        if (!inputHandler.isValidAmountOfArgs(args.length)) {
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (!inputHandler.areValidFileTypes(inputFile, outputFile)) {
            return;
        }

        if (!inputHandler.inputFileExists(inputFile)) {
            return;
        }

        System.out.println("Good!");
    }
}