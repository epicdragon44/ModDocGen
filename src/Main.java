import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<DocComponent> arr = new ArrayList<>();

        //on first read, init all the component objects from input.txt
        Scanner sc = new Scanner(new File("input.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.contains("DOC")) { //activate the documentation
                String[] input = sc.nextLine().substring(8).split(",");
                String[] output = sc.nextLine().substring(9).split(",");

                String nextLine = sc.nextLine().replaceAll("\\{", "");
                String description = line.split(":")[line.split(":").length-1].trim();
                String name = getName(nextLine).trim();
                if (line.contains("Component:")) { //the item here is a component
                    arr.add(new DocComponent(name, description, nextLine,true, input, output));
                }
                if (line.contains("Function:")) { //the item here is a function
                    arr.add(new DocComponent(name, description, nextLine,false, input, output));
                }
            }
        }
        sc.close();

        //on second read of input.txt, parse render() functions for one of the subcomponents
        Scanner sc2 = new Scanner(new File("input.txt"));
        while (sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if (line.contains("DOC")) { //activate the documentation
                String[] input = sc2.nextLine().substring(8).split(",");
                String[] output = sc2.nextLine().substring(9).split(",");

                String nextLine = sc2.nextLine().replaceAll("\\{", "");
                String description = line.split(":")[line.split(":").length-1].trim();
                String name = getName(nextLine).trim();
                while (sc2.hasNextLine()) {
                    String newLine = sc2.nextLine();
                    if (newLine.startsWith("}")) { //if end of the component, break and read for the next DOC
                        break;
                    } else {
                        String subcomponentname = lineHasASubcomponent(newLine, arr);
                        if (!subcomponentname.equals("")) {
                            //nothing in this dummy doccomponent we're using to search for the actual component actually matters except name, as per the equals method in doccomponent
                            arr.get(arr.indexOf(new DocComponent(name, description, nextLine,true, input, output))).addSubComponent(subcomponentname);
                        }
                    }
                }
            }
        }
        sc2.close();

        //at the end, output a full to README.md of the sorted doc components
        Collections.sort(arr);
        PrintWriter pw = new PrintWriter(new File("README.md"));
        try {
            Scanner sc3 = new Scanner(new File("defaultheader.txt"));
            while (sc3.hasNextLine())
                pw.println(sc3.nextLine()+"\n");
            sc3.close();
            pw.println("\n\n\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (DocComponent comp : arr) {
            pw.println(comp);
        }
        pw.close();
    }

    public static String lineHasASubcomponent(String lineOfCode, ArrayList<DocComponent> arr) {
        for (DocComponent comp : arr) {
            if (lineOfCode.contains(comp.name)) {
                return comp.name;
            }
        }
        return "";
    }

    public static String getName(String lineOfCode) {
        if (lineOfCode.startsWith("class")) {
            return lineOfCode.split(" ")[1];
        } else if (lineOfCode.startsWith("function")) {
            return lineOfCode.substring(lineOfCode.indexOf(" "), lineOfCode.indexOf("("));
        }
        return "ERROR";
    }
}

class DocComponent implements Comparable<DocComponent>{
    //passed in text
    public String name;
    public String description;
    public ArrayList<String> subcomponents;
    public String lineOfCode;
    public String[] input;
    public String[] output;
    public boolean type; //true for component, false for function

    //generated text
    public String typeText;
    public String header;
    public String code;
    public String[] subcomponentlinks;

    public DocComponent(String name, String description, String lineOfCode, boolean type, String[] input, String[] output) {
        this.name = name;
        this.description = description;
        this.lineOfCode = lineOfCode;
        this.type = type;
        this.subcomponents = new ArrayList<>();
        this.input = input;
        this.output = output;
    }

    public void addSubComponent(String subcomponents) {
        this.subcomponents.add(subcomponents);
    }

    public void generateText() {
        header = "## " + name;
        code = "```javascript\n" + lineOfCode + "\n```";
        typeText = (type) ? ("_Component_") : ("_Function_");
        subcomponentlinks = new String[subcomponents.size()];
        for (int i = 0; i < subcomponents.size(); i++) {
            subcomponentlinks[i] = "["+subcomponents.get(i)+"](#"+subcomponents.get(i)+")";
        }
    }

    @Override
    public int compareTo(DocComponent docComponent) {
        if (!this.type && docComponent.type)
            return -1;
        else if (this.type && !docComponent.type)
            return 1;
        else
            return docComponent.subcomponents.size()-this.subcomponents.size();
    }

    @Override
    public String toString() {
        generateText();

        StringBuilder output = new StringBuilder();

        output.append(header+"\n");
        output.append(typeText+"\n");
        output.append(code+"\n\n");
        output.append(description+"\n\n");
        output.append("**Input:**");
        for (String s : this.input) {
            output.append(" " + s.trim());
        }
        output.append("\n\n");
        output.append("**Output:**");
        for (String s : this.output) {
            output.append(" " + s.trim());
        }
        output.append("\n\n");
        if (subcomponentlinks.length>0)
            output.append("Contains: " + "\n");
        for (String s : subcomponentlinks) {
            output.append(s+"\n");
        }
        output.append("\n\n\n");
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocComponent that = (DocComponent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}