package SOLID;

public class ISP_01 {

    /*
     * TASK:
     * This SimplePrinter is not a multi functional printer but a very
     * simple one.
     * Please fix this to obey the ISP (Interface Segregation Principle)!
     */
    
    public interface Print {
        void printDocument();
    }

    public interface Scan {
        void scanDocument();
    }

    public interface Fax {
        void faxDocument();
    }

    public static class SimplePrinter implements Print {
        @Override
        public void printDocument() {
            System.out.println("SimplePrinter: Sending document to the printer ...");
        }
    }

    public static class MultiFunctionPrinter implements Print, Scan, Fax {
        @Override
        public void printDocument() {
            System.out.println("MultiFunctionPrinter: Printing document...");
        }

        @Override
        public void scanDocument() {
            System.out.println("MultiFunctionPrinter: Scanning document...");
        }

        @Override
        public void faxDocument() {
            System.out.println("MultiFunctionPrinter: Faxing document...");
        }
    }

    public static void main(String[] args) {
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.printDocument();

        System.out.println("---");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.printDocument();
        mfp.scanDocument();
        mfp.faxDocument();
    }
}