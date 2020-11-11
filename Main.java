package sorting;

public class Main {
    public static void main(final String[] args) {
        String dtype = "word", stype = "natural", Ifile = null, Ofile = null;

        for (int  i = 0 ; i < args.length; i+=2) {
            if ("-dataType".equals(args[i])) {
                try {
                    if ("long".equals(args[i + 1]) ||
                        "word".equals(args[i + 1]) ||
                        "line".equals(args[i + 1])) {
                        dtype = args[i + 1];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No data type defined!");
                }
            } else if ("-sortingType".equals(args[i])) {
                try {
                    if ("byCount".equals(args[i + 1]) ||
                            "natural.".equals(args[i + 1])) {
                        stype = args[i + 1];
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No sorting type defined!");
                }
            } else if ("-inputFile".equals(args[i])) {
                try {
                    Ifile = args[i+1];
                } catch (ArrayIndexOutOfBoundsException e){ e.printStackTrace(); }
            } else if ("-outputFile".equals(args[i])) {
                try {
                    Ofile = args[i+1];
                } catch (ArrayIndexOutOfBoundsException e){ e.printStackTrace(); }
            }else{
                System.out.println("\"" + args[i] +
                        "\" is not a valid parameter. It will be skipped.");
            }
        }

        try {
            switch (dtype) {
                case "long":
                    new sortLong(stype, Ofile, Ifile);
                    break;
                case "line":
                    new sortLine(stype, Ofile, Ifile);
                    break;
//                case "-sortIntegers":
//                    new sortInteger();
//                    break;
                default:
                    new sortWord(stype, Ofile, Ifile);
                    break;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            new sortWord(stype, Ofile, Ifile);
        }
    }
}
