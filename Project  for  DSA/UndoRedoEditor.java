
import java.util.*;

public class UndoRedoEditor {
    static Stack<String> undo = new Stack<>();
    static Stack<String> redo = new Stack<>();
    static String text = "";

    static void addText(String s) {
        undo.push(text);
        text += s;
        redo.clear();
    }

    static void undo() {
        if (!undo.empty()) {
            redo.push(text);
            text = undo.pop();
        } else System.out.println("Nothing to Undo!");
    }

    static void redo() {
        if (!redo.empty()) {
            undo.push(text);
            text = redo.pop();
        } else System.out.println("Nothing to Redo!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1.Add Text  2.Undo  3.Redo  4.Display  5.Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter text: ");
                    addText(sc.nextLine());
                    break;
                case 2: undo(); break;
                case 3: redo(); break;
                case 4:
                    System.out.println("Text: " + text);
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (ch != 5);

        sc.close();
    }
}
